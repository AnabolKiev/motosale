import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import ReactPaginate from 'react-paginate';

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
        this.state = {data: undefined, offset: 0, sizePerPage: props.sizePerPage};
        this.handlePageClick = this.handlePageClick.bind(this);
    }

    loadFromServer(props, offset) {
        var data = {};
//        $('#searchForm').find(':input').not(':button, :submit, :reset').each(function() {
//            data[this.name] = $(this).val();
//        });
        data['categoryId'] = props.categoryId;
        data['sizePerPage'] = this.state.sizePerPage;
        data['pageNumber'] = offset;

        console.log('loadFromServer ' + data['categoryId'] + ' offset=' + offset);

        $.ajax({
            url      : this.props.url,
            data     : data,
            dataType : 'JSON',
            type     : 'GET',
            success: data => {
                this.setState({data: data.content, pageCount: data.totalPages, offset: offset});
            },
            error: (xhr, status, err) => {
                console.error(this.props.url, status, err.toString());
            }
        });
    }

    componentWillMount() {
        console.log('componentWillMount');
        this.loadFromServer(this.props, 0);
    }

    componentWillReceiveProps(nextProps) {
        console.log('componentWillReceiveProps. nextProprs.categoryId = ' + nextProps.categoryId);
        if (nextProps.categoryId != this.props.categoryId) {
            this.loadFromServer(nextProps, 0);
        }
    }

    shouldComponentUpdate(nextProps, nextState){
        console.log('shouldComponentUpdate');
        return true;
    }

    componentWillUpdate(nextProps, nextState) {
        console.log('componentWillUpdate');
    }


    handlePageClick(data) {
        this.setState({offset: data.selected}, () => {
            this.loadFromServer(this.props, data.selected);
        });
    };

    render() {
        console.log('Rendering ' + this.props.categoryId);
        if (!this.state.data) {
            return (
                <div className="searchResult">Загрузка...</div>
            );
        } else
        if (this.state.data.length == 0) {
            return (
                <div className="searchResult">Поиск не дал результатов</div>
            );
        } else {
            return(
                <div className="searchResult">
                    <ReactPaginate previousLabel={"previous"}
                                   nextLabel={"next"}
                                   breakLabel={<a href="">...</a>}
                                   breakClassName={"break-me"}
                                   pageCount={this.state.pageCount}
                                   marginPagesDisplayed={2}
                                   pageRangeDisplayed={2}
                                   forcePage={this.state.offset}
                                   onPageChange={this.handlePageClick}
                                   containerClassName={"pagination"}
                                   subContainerClassName={"pages pagination"}
                                   activeClassName={"active"} />
                    <Models data={this.state.data}/>
                </div>
            );
        }
    }
};

function searchModels() {
    event.preventDefault();
    var categoryId = $('#categorySelect').val();
    ReactDOM.render(<SearchResult url='/ajax/searchModels/' sizePerPage={20} categoryId={categoryId}/>, document.getElementById('test'))
}

$(document).ready( function() {
    $('#searchModels').click(function() {
        searchModels();
    });
});