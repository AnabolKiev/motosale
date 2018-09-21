var gulp = require('gulp');
var browserify = require('browserify');
var babelify = require('babelify');
var source = require('vinyl-source-stream');
var buffer = require('vinyl-buffer');
var rigger = require('gulp-rigger');
var uglify = require('gulp-uglify');

gulp.task('build', function () {
    return browserify({entries: './src/main/webapp/WEB-INF/resources/js/script.jsx', extensions: ['.jsx'], debug: false})
        .transform('babelify', {presets: ['es2015', 'react']})
        .bundle()
        .pipe(source('script.js'))
	.pipe(buffer())
	.pipe(uglify())
        .pipe(gulp.dest('src/main/webapp/WEB-INF/resources/js'));
});

gulp.task('build2', function () {
    return browserify({entries: './src/main/webapp/WEB-INF/resources/js/scriptManufacturer.jsx', extensions: ['.jsx'], debug: false})
        .transform('babelify', {presets: ['es2015', 'react']})
        .bundle()
        .pipe(source('scriptManufacturer.js'))
	.pipe(buffer())
	.pipe(uglify())
        .pipe(gulp.dest('src/main/webapp/WEB-INF/resources/js'));
});

gulp.task('jsp', function () {
    gulp.src('src/main/webapp/WEB-INF/jsp/rigger/*.jsp')
        .pipe(rigger())
        .pipe(gulp.dest('src/main/webapp/WEB-INF/jsp'));
});

gulp.task('watch', ['build'], function () {
    gulp.watch('*.jsx', ['build']);
});

gulp.task('default', ['watch']);