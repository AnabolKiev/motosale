var gulp = require('gulp');
var browserify = require('browserify');
var browserifyshim = require('browserify-shim');
var babelify = require('babelify');
var source = require('vinyl-source-stream');

gulp.task('build', function () {
    return browserify({entries: './src/main/webapp/WEB-INF/js/script.jsx', extensions: ['.jsx'], debug: false})
        .transform('babelify', {presets: ['es2015', 'react']})
        .bundle()
        .pipe(source('script.js'))
        .pipe(gulp.dest('src/main/webapp/WEB-INF/js'));
});

gulp.task('build2', function () {
    return browserify({entries: './src/main/webapp/WEB-INF/js/scriptManufacturer.jsx', extensions: ['.jsx'], debug: false})
        .transform('babelify', {presets: ['es2015', 'react']})
        .bundle()
        .pipe(source('scriptManufacturer.js'))
        .pipe(gulp.dest('src/main/webapp/WEB-INF/js'));
});

gulp.task('watch', ['build'], function () {
    gulp.watch('*.jsx', ['build']);
});

gulp.task('default', ['watch']);