import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import ReactPaginate from 'react-paginate';

export class Models extends Component{
    render(){
        var models = this.props.data.map(function(model, i) {
            return (
                <tr key={i}>
                    <td>
                        {model.manufacturer.name}
                    </td>
                    <td>
                        {model.name}
                    </td>
                    <td>
                        {model.year}
                    </td>

                </tr>
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
        data['category'] = props.categories;
        data['finalDriveType'] = props.finalDriveTypes;
        data['yearFrom'] = props.yearFrom;
        data['yearTo'] = props.yearTo;
        data['displacementFrom'] = props.displacementFrom;
        data['displacementTo'] = props.displacementTo;
        data['sizePerPage'] = this.state.sizePerPage;
        data['pageNumber'] = offset;

        $.ajax({
            url      : this.props.url,
            data     : data,
            traditional: true,
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
        if (nextProps != this.props) {
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
        console.log('Rendering ' + this.props.categories);
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
                                   initialPage={this.state.offset}
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
    var categories = $('#categorySelect').val();
    var finalDriveTypes = $('#finalDriveTypeSelect').val();
    var yearFrom = $('#yearFromSelect').val();
    var yearTo = $('#yearToSelect').val();
    var displacementFrom = $('#displacementFromSelect').val();
    var displacementTo = $('#displacementToSelect').val();
    ReactDOM.render(<SearchResult url='/ajax/searchModels/' sizePerPage={30} categories={categories} finalDriveTypes={finalDriveTypes}
    yearFrom={yearFrom} yearTo={yearTo} displacementFrom={displacementFrom} displacementTo={displacementTo} />, document.getElementById('test'))
}

$(document).ready( function() {
    $('#categorySelect').multiselect({
        columns: 1,
        selectAll: true,
        texts: {
            placeholder : 'Выберите тип мотоцикла',
            selectAll   : 'Выбрать все',
            unselectAll : 'Убрать все',
            noneSelected: 'Не выбрано',
            selectedOptions: ' выбрано'
        }
    });

    $('#finalDriveTypeSelect').multiselect({
        columns: 1,
        selectAll: true,
        texts: {
            placeholder : 'Выберите тип привода',
            selectAll   : 'Выбрать все',
            unselectAll : 'Убрать все',
            noneSelected: 'Не выбрано',
            selectedOptions: ' выбрано'
        }
    });

    var thisYear = (new Date()).getFullYear();
    for (var i = thisYear; i >= 1900; i--) {
        $('<option>', {value: i, text: i}).appendTo('.year');
    };

    var displacementArray = [50,125,200,400,600,800,1000];
    for (var i = 0; i < displacementArray.length; i++) {
        $('<option>', {value: displacementArray[i], text: displacementArray[i] + ' см3'}).appendTo('.displacement');
    }

    $('#searchModels').click(function () {
        searchModels();
    });
});