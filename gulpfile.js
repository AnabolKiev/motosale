var gulp = require('gulp');
var browserify = require('browserify');
var browserifyshim = require('browserify-shim');
var babelify = require('babelify');
var source = require('vinyl-source-stream');
var buffer = require('vinyl-buffer');
var rigger = require('gulp-rigger');
var uglify = require('gulp-uglify');

gulp.task('index', function () {
    return browserify({entries: 'src/main/webapp/WEB-INF/resources/js/jsx/script.jsx', extensions: ['.jsx'], debug: false})
        .transform('babelify', {presets: ['es2015', 'react']})
	.transform(browserifyshim)
        .bundle()
        .pipe(source('script.js'))
	.pipe(buffer())
        .pipe(gulp.dest('src/main/webapp/WEB-INF/resources/js'));
});

gulp.task('manufacturer', function () {
    return browserify({entries: 'src/main/webapp/WEB-INF/resources/js/jsx/scriptManufacturer.jsx', extensions: ['.jsx'], debug: false})
        .transform('babelify', {presets: ['es2015', 'react']})
	.transform(browserifyshim)
        .bundle()
        .pipe(source('scriptManufacturer.js'))
	.pipe(buffer())
        .pipe(gulp.dest('src/main/webapp/WEB-INF/resources/js'));
});

gulp.task('jsp', function () {
    gulp.src('src/main/webapp/WEB-INF/jsp/rigger/*.jsp')
   .pipe(rigger())
   .pipe(gulp.dest('src/main/webapp/WEB-INF/jsp'));
});

gulp.task('watch', function () {
    gulp.watch('src/main/webapp/WEB-INF/resources/js/jsx/script.jsx', ['index']);
    gulp.watch('src/main/webapp/WEB-INF/resources/js/jsx/scriptManufacturer.jsx', ['manufacturer']);
    gulp.watch('src/main/webapp/WEB-INF/jsp/rigger/**/*.jsp', ['jsp']);

});

gulp.task('default', ['watch']);
