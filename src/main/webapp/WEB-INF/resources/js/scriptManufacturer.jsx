import ReactPaginate from 'react-paginate';

export class Models extends Component{
    render(){
        var modelRows = [];
        var models = this.props.data; // Object with array of Models (name as a key and array of years)
        for (var key in models) {
            if (models.hasOwnProperty(key)) {
                let years = models[key].map(function(year, i) {
                    return(
                        <li key={i}><a href={'/bike/' + manufacturer + '/' + key + '/' + year}>{year}</a></li>
                    )
                });
                modelRows.push(
                    <tr key={key}>
                        <td>
                            {key}
                        </td>
                        <td>
                            <ul>
                                {years}
                            </ul>
                        </td>
                    </tr>
                );
            }
        }

        return(
            <table className="model-table">
                <tbody>
                    <tr>
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
        this.state = {data: undefined, offset: 0, sizePerPage: props.sizePerPage, pageCount: Math.ceil(Object.keys(this.props.modelMap).length/props.sizePerPage)};
        this.handlePageClick = this.handlePageClick.bind(this);
    }

    getPageOfData(props, offset) {
        let pageOfData = {};
        for (var i = offset * props.sizePerPage; i < props.keys.length && i < (offset + 1) * props.sizePerPage; i++) {
            pageOfData[props.keys[i]] = props.modelMap[props.keys[i]];
        }
        this.setState({data: pageOfData, offset: offset});
    }

    componentWillMount() {
        this.getPageOfData(this.props, 0);
    }

    componentWillReceiveProps(nextProps) {
        if (nextProps != this.props) {
            this.getPageOfData(nextProps, 0);
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
}

function showModels(models, keys) {
    ReactDOM.render(<SearchResult modelMap={models} keys={keys} sizePerPage={30}/>, document.getElementById('searchResult'))
}

$(document).ready( function() {
    $.ajax({
        url      : '/ajax/searchModelsByManufacturer/',
        data     : {manufacturerId: manufacturerId},
        traditional: true,
        dataType : 'JSON',
        type     : 'GET',
        success: data => {
            var models = data;
            var keys = [];
            for (var key in data) {
                if (data.hasOwnProperty(key)) keys.push(key);
            }
            showModels(models, keys);
        },
        error: (xhr, status, err) => {
            console.error(status, err.toString());
        }
    });
});