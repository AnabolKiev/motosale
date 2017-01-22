var Result = React.createClass({
    render:function(){
        var result = this.props.manufacturers.map(function(manufacturer){
            return <ResultItem name={manufacturer.name} />
        });
        return(
                <table>
                    <tbody>
                        {result}
                    </tbody>
                </table>
        );
    }
});

var ResultItem = React.createClass({
    render:function(){
        var entry = this.props;
        return(
            <tr>
                <td>
                    {entry.name}
            </td>
            </tr>
        );
    }
});

const element = <h1>ReactJS test</h1>;

var Test = React.createClass({
    render:function(){
        return(
            <table>
                <tbody>
                {this.props.manufacturers}
                </tbody>
            </table>
        );
    }
});

var test = 'Test';
ReactDOM.render(<Test manufacturers={test} />, document.getElementById('test'));

function searchModels() {
    event.preventDefault();
    var data = {};
    $('#searchForm').find(':input').not(':button, :submit, :reset').each(function() {
        data[this.name] = $(this).val();
    });
    $.ajax({
        type: "GET",
        contentType : "application/json",
        url: '/ajax/searchModels/',
        data : data,
        dataType : "JSON"
    });
}

$(document).ready( function() {
    $('#searchModels').click(function() {
        searchModels();
    });
});