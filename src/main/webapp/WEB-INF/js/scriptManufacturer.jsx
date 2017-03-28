import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import ReactPaginate from 'react-paginate';

export class Models extends Component{
    render(){
        var models = '';
        this.props.data.forEach(function(key, value) {
            models = {models} +
                <tr key={key}>
                    <td>{key}</td>
                    <td></td>
                </tr>;
        });
        return(
            <table className="model-table">
                <tbody>
                    <tr>
                        <th>Модель</th>
                        <th>Год выпуска</th>
                    </tr>
                    {models}
                </tbody>
            </table>
        );
    }
};

export class SearchResult extends Component {
    constructor(props) {
        super(props);
        this.state = {data: undefined, offset: 0, sizePerPage: props.sizePerPage, pageCount: Math.ceil(modelMap.size/props.sizePerPage)};
        this.handlePageClick = this.handlePageClick.bind(this);
    }

    loadFromServer(props, offset) {
        let partOfData = new Map;
        // find part of data here
        for(let model of modelMap.keys()) {
            partOfData.set(model, modelMap.get(model))
        }
        this.setState({data: partOfData, offset: offset});
    }

    componentWillMount() {
        this.loadFromServer(this.props, 0);
    }

    componentWillReceiveProps(nextProps) {
        if (nextProps != this.props) {
            this.loadFromServer(nextProps, 0);
        }
    }

    handlePageClick(data) {
        this.setState({offset: data.selected}, () => {
            this.loadFromServer(this.props, data.selected);
        });
    };

    render() {
        if (!this.state.data) {
            return (
                <div>Загрузка...</div>
            );
        } else
        if (this.state.data.length == 0) {
            return (
                <div>Поиск не дал результатов</div>
            );
        } else {
            return(
                <div>
                    <Models data={this.state.data}/>
                    <div className="paginationDiv">
                        <ReactPaginate previousLabel={"назад"}
                                       nextLabel={"вперед"}
                                       breakLabel={<a href="">...</a>}
                                       breakClassName={"break-me"}
                                       pageCount={this.state.pageCount}
                                       marginPagesDisplayed={2}
                                       pageRangeDisplayed={2}
                                       initialPage={this.state.offset}
                                       forcePage={this.state.offset}
                                       onPageChange={this.handlePageClick}
                                       containerClassName={"pagination"}
                                       subContainerClassName={"pages pagination"}
                                       activeClassName={"active"} />
                    </div>
                </div>
            );
        }
    }
};

function searchModels() {
    ReactDOM.render(<SearchResult modelMap={modelMap}
                                  sizePerPage={30}
    />, document.getElementById('searchResult'))
}

$(document).ready( function() {
    $.ajax({
        url      : '/ajax/searchModelsByManufacturer/',
        data     : {manufacturerId: manufacturerId},
        traditional: true,
        dataType : 'JSON',
        type     : 'GET',
        success: data => {
            var obj = data;
            console.log(obj);
            searchModels();
        },
        error: (xhr, status, err) => {
            console.error(status, err.toString());
        }
    });

});