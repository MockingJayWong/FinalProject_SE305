<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <title>首页</title>
    <link href="resources/css/lib/semantic/dist/semantic.min.css" rel="stylesheet">
    <link href="resources/css/index.css" rel="stylesheet">
  </head>
  <body>
    <div class="whole">
      <div class="ui main container">
        <nav class="navigator">
          <div class="ui menu">
            <a href="#" class="item">首页</a>
            <a id="menu_item_1" href="account/login" class="item">登陆</a>
            <a id="menu_item_2" href="account/register" class="item">注册</a>
            <a id="menu_item_3" href="account/user/orderList" class="item">我的订单</a>
            <div class="right item">
              <div class="ui icon input">
                <input type="text" placeholder="搜索电影院或电影"><i class="search icon"></i>
              </div>
            </div>
          </div>
        </nav>
        <div class="content">
          <div class="header">
            <a href="#"><img src="resources/images/logo.png" alt="logo" class="logo"/></a>
          </div>
          <div class="main">
            <div class="carousel reco-movies">
              <div class="carousel-title">
                <h4>当前热映:</h4>
              </div>
              <div class="carousel-btn to-left"><i class="big arrow left icon"></i></div>
              <div class="carousel-btn to-right"><i class="big arrow right icon"></i></div>
              <div class="ui shape">
                <div id="movieList" class="sides">
                  
                </div>
              </div>
            </div>
            <div class="items-container reco-cinemas">
              <div class="title">
                <h4>热门电影院</h4>
              </div>
              <div id="cinemaList" class="items-content">
                
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="resources/css/lib/semantic/dist/semantic.min.js"></script>
    <script type="text/javascript">
        $(function() {
        	  function getCookie(name)
        	  {
		        	  var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
		        	  if(arr=document.cookie.match(reg))
		        	  return unescape(arr[2]);
		        	  else
		        	  return null;
        	  }
        	  var username = getCookie('username');
        	  if (username && username != '""') {
        		  $('#menu_item_1').attr('href', 'account/user').html('Hello, '+username);
        		  $('#menu_item_2').attr('href', 'account/logOut').html('退出');
        	  } else {
        		  $('#menu_item_3').hide();
        	  }
        	  
        	  
            // 获取current movie list
            $.ajax({
                url:'movie/currentMovieList',
                success: function(responseJson) {
                    var movieList = responseJson.data.list;
                    var innerHTML = ""
                    for (var movieIndex in movieList) {
                        if (movieIndex%4 == 0) {
                            if (movieIndex > 0) {
                                innerHTML += '</ul>';
                                innerHTML += '<ul class="side reco-movies-group carousel-item">';
                            } else {
                                innerHTML += '<ul class="active side reco-movies-group carousel-item">';
                            }
                        }
                        var movie = movieList[movieIndex];
                        innerHTML += 
                            '<li class="reco-movie">'+
                                '<a href="movie/'+movie.id+'" >'+
                                    '<img src="resources/images/'+movie.url+'" >'+
                                '</a>'+
                                '<div class="reco-movie-info">'+
                                    '<div class="reco-movie-name">'+
                                        movie.movieName+
                                    '</div>'+
                                    '<div class="reco-movie-intro">'+
                                        movie.introduction+
                                    '</div>'+
                                    '<span class="reco-movie-rank">'+
                                        movie.score+
                                    '</span>'+
                                '</div>'+
                                '<a href="movie/'+movie.id+'#cinemas">'+
                                    '<button class="ui primary button purchase-btn">购票 </button>'+
                                '</a>'+
                            '</li>';
                        if (movieIndex == movieList.length-1) {
                            innerHTML += '</ul>';
                        }
                    }
                    $('#movieList').html(innerHTML);
                }
            });

            // 获取cinema list
            $.ajax({
                url:'cinema/cinemaList',
                success: function(responseJson) {
                    var cinemaList = responseJson.data.list;
                    var innerHTML = ""
                    for (var cinemaIndex in cinemaList) {
                        var cinema = cinemaList[cinemaIndex];
                        innerHTML += 
                            '<div class="item cinema-item">'+
                                '<div class="item-title cinema-name">'+
                                    cinema.cinemaName+
                                '</div>'+
                                '<div class="item-content">'+
                                    '<dl class="cinema-address cinema-info info">'+
                                        '<dt class="lable">'+
                                            '地址'+
                                        '</dt>'+
                                        '<dd class="value">'+
                                            cinema.address+
                                        '</dd>'+
                                    '</dl>'+
                                '</div>'+
                                '<div class="item-button">'+
                                    '<a href="cinema/'+cinema.id+'">'+
                                        '<button class="ui primary button purchase-btn">选座购票</button>'+
                                    '</a>'+
                                '</div>'+
                            '</div>';
                    }
                    $("#cinemaList").html(innerHTML);
                }
            });

            $(".to-left").click(function(e) {
                $(".shape").shape("flip left");
            });
            $(".to-right").click(function(e) {
                $(".shape").shape("flip right");
            });
        });

    </script>
</body>
</html>