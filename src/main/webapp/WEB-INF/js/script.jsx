import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import ReactPaginate from 'react-paginate';
import Paginator from 'react-paginate-component';

export class Models extends Component{
    render(){
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
};

export class SearchResult extends Component {
    constructor(props) {
        super(props);
        this.state = {data: [], offset: 0, sizePerPage: props.sizePerPage};
        this.handlePageClick = this.handlePageClick.bind(this);
    }

    loadFromServer() {
        var data = {};
        $('#searchForm').find(':input').not(':button, :submit, :reset').each(function() {
            data[this.name] = $(this).val();
        });
        data['sizePerPage'] = this.state.sizePerPage;
        data['pageNumber'] = this.state.offset;

        $.ajax({
            url      : this.props.url,
            data     : data,
            dataType : 'JSON',
            type     : 'GET',
            success: data => {
                this.setState({data: data.content, pageCount: data.totalPages});
            },
            error: (xhr, status, err) => {
                console.error(this.props.url, status, err.toString());
            }
        });
    }

    componentDidMount() {
        this.loadFromServer();
    }

    handlePageClick(data) {
        let selected = data.selected;
        this.setState({offset: selected}, () => {
            this.loadFromServer();
        });
    };

    render() {
        return(
            <div className="searchResult">
                <ReactPaginate previousLabel={"previous"}
                               nextLabel={"next"}
                               breakLabel={<a href="">...</a>}
                               breakClassName={"break-me"}
                               pageCount={this.state.pageCount}
                               marginPagesDisplayed={2}
                               pageRangeDisplayed={2}
                               onPageChange={this.handlePageClick}
                               containerClassName={"pagination"}
                               subContainerClassName={"pages pagination"}
                               activeClassName={"active"} />
                 <Models data={this.state.data}/>
            </div>
        );
    }
};

function searchModels() {
    event.preventDefault();
    ReactDOM.render(<SearchResult url='/ajax/searchModels/' sizePerPage={20}/>, document.getElementById('test'))
}

$(document).ready( function() {
    $('#searchModels').click(function() {
        searchModels();
    });
});