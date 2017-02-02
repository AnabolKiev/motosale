import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import ReactPaginate from 'react-paginate';
import Paginator from 'react-paginate-component';

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

export class SearchResult extends Component {
    constructor(props) {
        super(props);
        this.state = {data: [], offset: 0}
    }

    loadFromServer() {
        var data = {};
        $('#searchForm').find(':input').not(':button, :submit, :reset').each(function() {
            data[this.name] = $(this).val();
        });

        $.ajax({
            url      : '/ajax/searchModels/',
            data     : data,
            dataType : 'JSON',
            type     : 'GET',
            success: data => {
                this.setState({data: data.content, pageCount: data.number});
            },
            error: (xhr, status, err) => {
                console.error(this.props.url, status, err.toString());
            }
        });
    }

    componentDidMount() {
        this.loadFromServer();
        console.log('did mount');
    }

    handlePageClick (data) {
        let selected = data.number;
        let offset = Math.ceil(selected);
        console.log(offset);

        this.setState({offset: offset}, () => {
            this.loadFromServer();
        });
    };

    render() {
        return(
            <div className="searchResult">
                Страница {this.props.data.number} из {this.props.data.totalPages}
                <ReactPaginate previousLabel={"previous"}
                               nextLabel={"next"}
                               breakLabel={<a href="">...</a>}
                               breakClassName={"break-me"}
                               pageCount={5}
                               marginPagesDisplayed={2}
                               pageRangeDisplayed={5}
                               onPageChange={this.handlePageClick}
                               containerClassName={"pagination"}
                               subContainerClassName={"pages pagination"}
                               activeClassName={"active"} />
                 <Models data={this.props.data.content}/>
            </div>
        );
    }
};

function searchModels() {
    event.preventDefault();
    var data = {};
    $('#searchForm').find(':input').not(':button, :submit, :reset').each(function() {
        data[this.name] = $(this).val();
    });
    $.ajax({
        type: 'GET',
        contentType: 'application/json',
        url: '/ajax/searchModels/',
        data: data,
        dataType: 'json',
        success: function (response) {
            ReactDOM.render(<SearchResult data={response}/>, document.getElementById('test'))
        }
    });
}

$(document).ready( function() {
    $('#searchModels').click(function() {
        searchModels();
    });
});