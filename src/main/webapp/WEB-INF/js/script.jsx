import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import ReactPaginate from 'react-paginate';

var Models = React.createClass({
    render:function(){
        var models = this.props.data.map(function(model, i) {
            return (
                <tr key={i}><td>
                    {model.name}
                </td></tr>
            );
        });
        return(
            <div className="modelList">
                <table>
                    <tbody>
                        {models}
                    </tbody>
                </table>
            </div>
        );
    }
});

var Test = React.createClass({
    render:function(){
        return(
            <div className="searchResult">
                Страница {this.props.data.number} из {this.props.data.totalPages}
                 <Models data={this.props.data.content}/>
            </div>
        );
    }
});

function searchModels() {
    event.preventDefault();
    var data = {};
    $('#searchForm').find(':input').not(':button, :submit, :reset').each(function() {
        data[this.name] = $(this).val();
    });
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: '/ajax/searchModels/',
        data: data,
        dataType: "JSON",
        success: function (response) {
            ReactDOM.render(<Test data={response}/>, document.getElementById('test'))
        }
    });
}

$(document).ready( function() {
    $('#searchModels').click(function() {
        searchModels();
    });
});