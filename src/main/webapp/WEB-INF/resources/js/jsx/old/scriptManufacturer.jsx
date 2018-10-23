import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import SearchResult from '../searchResult';

function searchModelsByFilters() {
    $.ajax({  // load all data
        url      : '/ajax/searchModelsAll/',
        data     : {manufacturer: $('#manufacturerSelect').val(),
            category: $('#categorySelect').val(),
            engineType: $('#engineTypeSelect').val(),
            finalDriveType: $('#finalDriveTypeSelect').val(),
            yearFrom: $('#yearFromSelect').val(),
            yearTo: $('#yearToSelect').val(),
            displacementFrom: $('#displacementFromSelect').val(),
            displacementTo: $('#displacementToSelect').val()},
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
}

function searchModelsByText() {
    $.ajax({  // load all data
        url      : '/ajax/searchModelsAll/',
        data     : {searchText: $('#searchText').val()},
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
}

$(document).ready( function() {
    $('#manufacturerSelect').multiselect({
        columns: 1,
        selectAll: true,
        search: true,
        texts: {
            placeholder : 'Выберите производителя',
            selectAll   : 'Выбрать все',
            unselectAll : 'Убрать все',
            noneSelected: 'Не выбрано',
            selectedOptions: ' выбрано',
            search: 'Поиск'
        }
    });

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

    $('#engineTypeSelect').multiselect({
        columns: 1,
        selectAll: true,
        texts: {
            placeholder : 'Выберите тип двигателя',
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
    }

    var displacementArray = [50,125,250,400,600,800,1000];
    for (var i = 0; i < displacementArray.length; i++) {
        $('<option>', {value: displacementArray[i], text: displacementArray[i] + ' см3'}).appendTo('.displacement');
    }

    $('#searchModels').click(function () {
        event.preventDefault();
        searchModelsByFilters();
    });

    $('#searchButton').click(function () {
        event.preventDefault();
        searchModelsByText();
    });

    if (manufacturerId != null)
    $.ajax({  // load all data
        url      : '/ajax/searchModelsByManufacturer/',
        data     : {manufacturerId: manufacturerId},
        traditional: true,
        dataType : 'JSON',
        type     : 'GET',
        success: data => {
            ReactDOM.render(<SearchResult models={data} sizePerPage={30}/>, document.getElementById('searchResultAfterTitle'))
        },
        error: (xhr, status, err) => {
            console.error(status, err.toString());
        }
    });
});
