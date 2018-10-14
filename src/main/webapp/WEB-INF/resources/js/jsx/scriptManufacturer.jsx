import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import ReactPaginate from 'react-paginate';

export class AggregatedModels extends Component{
    render(){
        var modelRows = this.props.data.map((model, i) => {
            let years = model[2].split(",").map((year, j) => { // build horizontal list of model years
                return(
                    <li key={j}><a href={'/bike/' + model[0] + '/' + model[1] + '/' + year}>{year}</a></li>
                )
            });
            return(
                <tr key={i}>
                    <td>
                        {model[0]}
                    </td>
                    <td>
                        {model[1]}
                    </td>
                    <td className="yearColumn">
                        <ul>
                            {years}
                        </ul>
                    </td>
                </tr>
            );
        });

        return(
            <table className="model-table">
                <tbody>
                <tr>
                    <th>Производитель</th>
                    <th>Модель</th>
                    <th>Год выпуска</th>
                </tr>
                {modelRows}
                </tbody>
            </table>
        );
    }
}

export class SearchResult extends Component {
    constructor(props) {
        super(props);
        this.state = {data: undefined, offset: 0, sizePerPage: props.sizePerPage, pageCount: Math.ceil(props.models.length/props.sizePerPage)};
        this.handlePageClick = this.handlePageClick.bind(this);
    }

    getPageOfData(props, offset) {
        let pageOfData = props.models.slice(offset * props.sizePerPage, (offset + 1) * props.sizePerPage);
        this.setState({data: pageOfData, offset: offset});
    }

    componentWillMount() {
        this.getPageOfData(this.props, 0);
    }

    componentWillReceiveProps(nextProps) {
        if (nextProps != this.props) {
            this.getPageOfData(nextProps, 0);
            this.setState({pageCount: Math.ceil(nextProps.models.length/nextProps.sizePerPage)})
        }
    }

    handlePageClick(data) {
        this.setState({offset: data.selected}, () => {
            this.getPageOfData(this.props, data.selected);
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
                    <AggregatedModels data={this.state.data}/>
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
}

$(document).ready( function() {
    $.ajax({  // load all data
        url      : '/ajax/searchModelsByManufacturer/',
        data     : {manufacturerId: manufacturerId},
        traditional: true,
        dataType : 'JSON',
        type     : 'GET',
        success: data => {
            ReactDOM.render(<SearchResult models={data} sizePerPage={30}/>, document.getElementById('searchResult'))
        },
        error: (xhr, status, err) => {
            console.error(status, err.toString());
        }
    });
});
