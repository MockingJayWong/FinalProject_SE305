var gulp = require("gulp");
var browserSync = require("browser-sync").create(),
    jade = require("gulp-jade"),
    less = require("gulp-less"),
    clean = require("gulp-clean");


gulp.task("server", ["build"], function() {
    browserSync.init({
        server: {
            baseDir: "./dest/",
            index: "html/index.html"
        }
    });

    gulp.watch("src/less/**/*.less", ["build-css"]);
    gulp.watch("src/jade/**/*.jade", ["build-html"]);
});

gulp.task("build-semantic", function() {
    return gulp.src("src/lib/**/**.*")
        .pipe(gulp.dest("dest/lib"))
})

gulp.task("build-css", function() {
    return gulp.src("src/less/*.less")
        .pipe(less())
        .pipe(gulp.dest("dest/css"))
        .pipe(browserSync.reload({
            stream: true
        }));
})

gulp.task("build-html", function() {
    return gulp.src("src/jade/*.jade")
        .pipe(jade({
            pretty: true
        }))
        .pipe(gulp.dest("dest/html"))
        .pipe(browserSync.reload({
            stream: true
        }));
})

gulp.task("build-assets", function() {
    return gulp.src("src/assets/**.*")
        .pipe(gulp.dest("dest/assets"))
        .pipe(browserSync.reload({
            stream: true
        }));
})

gulp.task("build-js", function() {
    return gulp.src("src/js/**.*")
        .pipe(gulp.dest("dest/js"))
        .pipe(browserSync.reload({
            stream: true
        }))
})

gulp.task("clean", function() {
    return gulp.src("./dest", {read: false})
        .pipe(clean());
});

gulp.task("build", ["build-html", "build-semantic", "build-css", "build-js", "build-assets"]);
gulp.task("default", ["server"]);