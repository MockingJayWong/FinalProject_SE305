<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <title>首页</title>
    <link href="../resources/css/lib/semantic/dist/semantic.min.css" rel="stylesheet">
    <link href="../resources/css/movie.css" rel="stylesheet">
  </head>
  <body>
    <div class="whole">
      <div class="ui main container">
        <nav class="navigator">
          <div class="ui menu"><a id="menu_item_1" href="account/login" class="item">登陆</a><a id="menu_item_2" href="account/register" class="item">注册</a>
            <div class="right item">
              <div class="ui icon input">
                <input type="text" placeholder="搜索电影院或电影"><i class="search icon"></i>
              </div>
            </div>
          </div>
        </nav>
        <div class="content">
          <div class="header">
            <div class="logo">logo</div>
          </div>
          <div id="movie_detail" class="movie-intro detail-intro">
            <!-- to be ajax -->
          </div><a name="cinemas"></a>
          <div class="tab-container">
            <div class="ui attached tabular menu reco-cinemas"><a data-tab="cinemas" class="item active">上映影院</a><a data-tab="recommends" class="item">热门影评</a>
            </div>
            <div data-tab="cinemas" class="ui tab attached segment active">
              <div class="items-container reco-cinemas">
                <div class="title">
                  <h4>热门电影院</h4>
                </div>
                <div id="cinema_list" class="items-content">
              		<!-- to be ajax -->
                </div>
              </div>
            </div>
            <div data-tab="recommends" class="ui tab attached segment">这里还没有东西哦
            </div>
          </div>
          <div class="modal-container">
            <div class="ui modal first"><i class="close icon"></i>
              <div class="content">
                <div class="table-container">
                  <table class="ui celled table">
                    <thead>
                      <tr>
                        <th>放映开始时间</th>
                        <th>放映结束时间</th>
                        <th>语言版本</th>
                        <th>放映厅</th>
                        <th>售价</th>
                        <th>在线选座</th>
                      </tr>
                    </thead>
                    <tbody id="sessions_tbody" class="reco-sections">
                      <tr class="section-item">
                        <td class="startTime">22:25</td>
                        <td class="endTime">23:55</td>
                        <td class="language">英语3D</td>
                        <td class="room">二号厅</td>
                        <td class="price">31.5</td>
                        <td>
                          <button class="ui primary button purchase-btn">购票   </button>
                        </td>
                      </tr>
                      <tr class="section-item">
                        <td class="startTime">22:25</td>
                        <td class="endTime">23:55</td>
                        <td class="language">英语3D</td>
                        <td class="room">二号厅</td>
                        <td class="price">31.5</td>
                        <td>
                          <button class="ui primary button purchase-btn">购票   </button>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
          <div class="modal-container">
            <div class="ui modal second"><i class="close icon"></i>
              <div class="content">
                <div class="room-container">
                  <div class="ui horizontal divider screen">屏幕</div>
                  <div class="seats-container">
                    <div class="seats row row-1">
                      <input type="checkbox" class="seat row-1 col-1"/>
                      <input type="checkbox" class="seat row-1 col-2"/>
                      <input type="checkbox" class="seat row-1 col-3"/>
                      <input type="checkbox" class="seat row-1 col-4"/>
                      <input type="checkbox" class="seat row-1 col-5"/>
                      <input type="checkbox" class="seat row-1 col-6"/>
                      <input type="checkbox" class="seat row-1 col-7"/>
                      <input type="checkbox" class="seat row-1 col-8"/>
                      <input type="checkbox" class="seat row-1 col-9"/>
                      <input type="checkbox" class="seat row-1 col-10"/>
                      <input type="checkbox" class="seat row-1 col-11"/>
                    </div>
                    <div class="seats row row-2">
                      <input type="checkbox" class="seat row-2 col-1"/>
                      <input type="checkbox" class="seat row-2 col-2"/>
                      <input type="checkbox" class="seat row-2 col-3"/>
                      <input type="checkbox" class="seat row-2 col-4"/>
                      <input type="checkbox" class="seat row-2 col-5"/>
                      <input type="checkbox" class="seat row-2 col-6"/>
                      <input type="checkbox" class="seat row-2 col-7"/>
                      <input type="checkbox" class="seat row-2 col-8"/>
                      <input type="checkbox" class="seat row-2 col-9"/>
                      <input type="checkbox" class="seat row-2 col-10"/>
                      <input type="checkbox" class="seat row-2 col-11"/>
                    </div>
                    <div class="seats row row-3">
                      <input type="checkbox" class="seat row-3 col-1"/>
                      <input type="checkbox" class="seat row-3 col-2"/>
                      <input type="checkbox" class="seat row-3 col-3"/>
                      <input type="checkbox" class="seat row-3 col-4"/>
                      <input type="checkbox" class="seat row-3 col-5"/>
                      <input type="checkbox" class="seat row-3 col-6"/>
                      <input type="checkbox" class="seat row-3 col-7"/>
                      <input type="checkbox" class="seat row-3 col-8"/>
                      <input type="checkbox" class="seat row-3 col-9"/>
                      <input type="checkbox" class="seat row-3 col-10"/>
                      <input type="checkbox" class="seat row-3 col-11"/>
                    </div>
                    <div class="seats row row-4">
                      <input type="checkbox" class="seat row-4 col-1"/>
                      <input type="checkbox" class="seat row-4 col-2"/>
                      <input type="checkbox" class="seat row-4 col-3"/>
                      <input type="checkbox" class="seat row-4 col-4"/>
                      <input type="checkbox" class="seat row-4 col-5"/>
                      <input type="checkbox" class="seat row-4 col-6"/>
                      <input type="checkbox" class="seat row-4 col-7"/>
                      <input type="checkbox" class="seat row-4 col-8"/>
                      <input type="checkbox" class="seat row-4 col-9"/>
                      <input type="checkbox" class="seat row-4 col-10"/>
                      <input type="checkbox" class="seat row-4 col-11"/>
                    </div>
                    <div class="seats row row-5">
                      <input type="checkbox" class="seat row-5 col-1"/>
                      <input type="checkbox" class="seat row-5 col-2"/>
                      <input type="checkbox" class="seat row-5 col-3"/>
                      <input type="checkbox" class="seat row-5 col-4"/>
                      <input type="checkbox" class="seat row-5 col-5"/>
                      <input type="checkbox" class="seat row-5 col-6"/>
                      <input type="checkbox" class="seat row-5 col-7"/>
                      <input type="checkbox" class="seat row-5 col-8"/>
                      <input type="checkbox" class="seat row-5 col-9"/>
                      <input type="checkbox" class="seat row-5 col-10"/>
                      <input type="checkbox" class="seat row-5 col-11"/>
                    </div>
                    <div class="seats row row-6">
                      <input type="checkbox" class="seat row-6 col-1"/>
                      <input type="checkbox" class="seat row-6 col-2"/>
                      <input type="checkbox" class="seat row-6 col-3"/>
                      <input type="checkbox" class="seat row-6 col-4"/>
                      <input type="checkbox" class="seat row-6 col-5"/>
                      <input type="checkbox" class="seat row-6 col-6"/>
                      <input type="checkbox" class="seat row-6 col-7"/>
                      <input type="checkbox" class="seat row-6 col-8"/>
                      <input type="checkbox" class="seat row-6 col-9"/>
                      <input type="checkbox" class="seat row-6 col-10"/>
                      <input type="checkbox" class="seat row-6 col-11"/>
                    </div>
                    <div class="seats row row-7">
                      <input type="checkbox" class="seat row-7 col-1"/>
                      <input type="checkbox" class="seat row-7 col-2"/>
                      <input type="checkbox" class="seat row-7 col-3"/>
                      <input type="checkbox" class="seat row-7 col-4"/>
                      <input type="checkbox" class="seat row-7 col-5"/>
                      <input type="checkbox" class="seat row-7 col-6"/>
                      <input type="checkbox" class="seat row-7 col-7"/>
                      <input type="checkbox" class="seat row-7 col-8"/>
                      <input type="checkbox" class="seat row-7 col-9"/>
                      <input type="checkbox" class="seat row-7 col-10"/>
                      <input type="checkbox" class="seat row-7 col-11"/>
                    </div>
                    <div class="seats row row-8">
                      <input type="checkbox" class="seat row-8 col-1"/>
                      <input type="checkbox" class="seat row-8 col-2"/>
                      <input type="checkbox" class="seat row-8 col-3"/>
                      <input type="checkbox" class="seat row-8 col-4"/>
                      <input type="checkbox" class="seat row-8 col-5"/>
                      <input type="checkbox" class="seat row-8 col-6"/>
                      <input type="checkbox" class="seat row-8 col-7"/>
                      <input type="checkbox" class="seat row-8 col-8"/>
                      <input type="checkbox" class="seat row-8 col-9"/>
                      <input type="checkbox" class="seat row-8 col-10"/>
                      <input type="checkbox" class="seat row-8 col-11"/>
                    </div>
                    <div class="seats row row-9">
                      <input type="checkbox" class="seat row-9 col-1"/>
                      <input type="checkbox" class="seat row-9 col-2"/>
                      <input type="checkbox" class="seat row-9 col-3"/>
                      <input type="checkbox" class="seat row-9 col-4"/>
                      <input type="checkbox" class="seat row-9 col-5"/>
                      <input type="checkbox" class="seat row-9 col-6"/>
                      <input type="checkbox" class="seat row-9 col-7"/>
                      <input type="checkbox" class="seat row-9 col-8"/>
                      <input type="checkbox" class="seat row-9 col-9"/>
                      <input type="checkbox" class="seat row-9 col-10"/>
                      <input type="checkbox" class="seat row-9 col-11"/>
                    </div>
                    <div class="seats row row-10">
                      <input type="checkbox" class="seat row-10 col-1"/>
                      <input type="checkbox" class="seat row-10 col-2"/>
                      <input type="checkbox" class="seat row-10 col-3"/>
                      <input type="checkbox" class="seat row-10 col-4"/>
                      <input type="checkbox" class="seat row-10 col-5"/>
                      <input type="checkbox" class="seat row-10 col-6"/>
                      <input type="checkbox" class="seat row-10 col-7"/>
                      <input type="checkbox" class="seat row-10 col-8"/>
                      <input type="checkbox" class="seat row-10 col-9"/>
                      <input type="checkbox" class="seat row-10 col-10"/>
                      <input type="checkbox" class="seat row-10 col-11"/>
                    </div>
                    <div class="seats row row-11">
                      <input type="checkbox" class="seat row-11 col-1"/>
                      <input type="checkbox" class="seat row-11 col-2"/>
                      <input type="checkbox" class="seat row-11 col-3"/>
                      <input type="checkbox" class="seat row-11 col-4"/>
                      <input type="checkbox" class="seat row-11 col-5"/>
                      <input type="checkbox" class="seat row-11 col-6"/>
                      <input type="checkbox" class="seat row-11 col-7"/>
                      <input type="checkbox" class="seat row-11 col-8"/>
                      <input type="checkbox" class="seat row-11 col-9"/>
                      <input type="checkbox" class="seat row-11 col-10"/>
                      <input type="checkbox" class="seat row-11 col-11"/>
                    </div>
                  </div>
                  <div class="note seat">
                    <div class="ui checkbox">
                      <input type="checkbox" onclick="return false;"/>
                      <label>可选座位</label>
                    </div>
                    <div class="ui checkbox">
                      <input type="checkbox" checked="checked" onclick="return false;"/>
                      <label>已选座位</label>
                    </div>
                    <div class="ui checkbox">
                      <input type="checkbox" checked="checked" disabled="disabled"/>
                      <label>已售座位</label>
                    </div>
                  </div>
                </div>
                <div class="btn-container">
                  <!-- temporary-->
                    <button id="generate_order_btn" class="ui primary button purchase-btn">去支付</button></a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
      <script src="../resources/css/lib/semantic/dist/semantic.min.js"></script>
      <script type="text/javascript">
        $(document).ready(function(){
        	
        	function getCookie(name)
          {
              var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
              if(arr=document.cookie.match(reg))
              return unescape(arr[2]);
              else
              return null;
          }
          var username = getCookie('username');
          if (username) {
            $('#menu_item_1').attr('href', 'account/user').html('Hello, '+username);
            $('#menu_item_2').attr('href', 'account/logOut').html('退出');
          }
        	
        	// 从url获取movieId
        	var url = window.location.href;
					var temp_array =  url.split('/');
					var movie_id = temp_array[temp_array.length-1].split('#')[0];
		            
					// 获取movie detail
            $.ajax({
                url:'detail',
                data:{movieId:movie_id},
                success: function(responseJson) {
                  var movie_detial_html = 
                    '<div class="movie-title title">\
                      <h3>movie_name</h3>\
                    </div><img src="../assets/movie_url" class="movie-poster poster"/>\
                    <div class="movie-rating rating">\
                      <div data-rating="3" data-max-rating="5" class="ui rating"></div><span class="rating-value">movie_score</span>\
                    </div>\
                    <dl class="movie-infos infos">\
                      <dl class="movie-type movie-info info">\
                        <dt class="label">类型</dt>\
                        <dd class="value">movie_type</dd>\
                      </dl>\
                      <dl class="movie-region movie-info info">\
                        <dt class="label">地区</dt>\
                        <dd class="value">美国,芬兰</dd>\
                      </dl>\
                      <dl class="movie-period movie-info info">\
                        <dt class="label">时长</dt>\
                        <dd class="value">movie_length</dd>\
                      </dl>\
                      <dl class="movie-director movie-info info">\
                        <dt class="label">导演</dt>\
                        <dd class="value">movie_director</dd>\
                      </dl>\
                      <dl class="movie-actors movie-info info">\
                        <dt class="label">主演</dt>\
                        <dd class="value">movie_actor</dd>\
                      </dl>\
                    </dl>\
                    <div class="movie-plot plot">\
                      <h5 class="title">剧情</h5>\
                      <div class="content">movie_intro</div>\
                    </div>';

                  var movie = responseJson.data.movie;
                  movie_detial_html = movie_detial_html.replace('movie_name', movie.movieName).replace('movie_score', movie.score).replace('movie_url', movie.url).replace('movie_type', movie.type).replace('movie_length', movie.length).replace('movie_director', movie.director).replace('movie_actor', movie.actor).replace('movie_intro', movie.introduction);
                  $("#movie_detail").html(movie_detial_html);
                }
            });

            var cinema_id_map = {};
			
            $.ajax({
              url:"../cinema/cinemaList",
              data:{movieId:movie_id},
              success:function(responseJson) {
            	  var cinema_html = 
                      '<div class="item cinema-item">\
                        <div class="item-title cinema-name">cinema_name</div>\
                        <div class="item-content">\
                          <dl class="cinema-address cinema-info info">\
                            <dt class="label">地址</dt>\
                            <dd class="value">cinema_address</dd>\
                          </dl>\
                          <dl class="cinema-section cinema-info info">\
                            <dt class="label">场次</dt>\
                            <dd class="value">cinema_sessions</dd>\
                          </dl>\
                        </div>\
                        <div class="item-button">\
                            <button id="cinema_btn_cinema_id" class="ui primary button purchase-btn">选座购票</button></div>\
                      </div>'

                var inner_html = "";
                var cinema_list = responseJson.data.list;
                var cinema_html_after_replace;
                for (var cinemaIndex in cinema_list) {
                  var cinema = cinema_list[cinemaIndex];
                  cinema_id_map[cinema.id] = cinema;
                  var sessions_str = "";
                  var session_list = cinema.sessions;
                  for (var sessionIndex in session_list) {
                    var session = session_list[sessionIndex];
                    sessions_str += session.start_time.toString();
                    if (sessionIndex < session_list.len-1) sessions_str += ' | ';
                  }
                  cinema_html_after_replace = cinema_html.replace('cinema_id', cinema.id).replace('cinema_name', cinema.cinemaName).replace('cinema_address', cinema.address).replace('cinema_sessions', sessions_str)
                  inner_html += cinema_html_after_replace;
                }
                $("#cinema_list").html(inner_html);
                $(".cinema-item .purchase-btn").click(select_session);
              }
            })
            
            function select_session(e) {
              var cinema_id = e.target.id.split('_')[2];
              var session_list = cinema_id_map[cinema_id].sessions;

              var session_tr_html = '<tr class="section-item">\
                                      <td class="startTime">session_start_time</td>\
                                      <td class="endTime">session_end_time</td>\
                                      <td class="language">session_language</td>\
                                      <td class="room">session_hall号厅</td>\
                                      <td class="price">session_price</td>\
                                      <td>\
                                        <button id="session_btn_session_id" class="ui primary button purchase-btn">购票   </button>\
                                      </td>\
                                    </tr>'

              var session_tr_html_after_replace;
              var session_list_html = "";
              for (sessionIndex in session_list) {
                var session = session_list[sessionIndex];
                var startTime = new Date(session.start_time);
                var endTime = new Date(session.end_time);
                session_tr_html_after_replace = session_tr_html.replace('session_id', session.id).replace('session_start_time', startTime.getHours()+':'+startTime.getMinutes()).replace('session_end_time', endTime.getHours()+':'+endTime.getMinutes()).replace('session_language', session.language).replace('session_hall', session.hall).replace('session_price', session.price);
                session_list_html += session_tr_html_after_replace;
              }

              $("#sessions_tbody").html(session_list_html);
              $(".first.modal").modal("show");

              $(".section-item .purchase-btn").click(select_seat);
            }
            
            var session_id;
            function select_seat(e) {
              session_id = e.target.id.split('_')[2];
              $.ajax({
                url:'../session/'+session_id,
                success:function(responseJson) {
                  $(".first.modal").modal("hide");
                  var sold_list = responseJson.data.list;
                  for (seatIndex in sold_list) {
                    /* if (sold_list[seatIndex] != '') {
                      var seat_x = parseInt(sold_list[seatIndex])/11+1;
                      var seat_y = parseInt(sold_list[seatIndex])%11+1;
                      $('.row'+seat_x).filter('.col'+seat_y).attr("checked","checked").attr("disabled", "disabled");
                    } */
                    var seat_x = sold_list[seatIndex][0];
                    var seat_y = sold_list[seatIndex][1];
                    $('.row-'+seat_x).filter('.col-'+seat_y).attr("checked","checked").attr("disabled", "disabled");
                  }
                  $(".second.modal").modal("show");
                }
              })
            }
            
            $('#generate_order_btn').click(function(e) {
              var seats_str = "";
              $('.seat').each(function() {
                if ($(this).is(':checked') && ! $(this).attr('disabled')) {
                  var seat_x_str = $(this).attr('class').split(' ')[1];
                  var x = parseInt(seat_x_str.split('-')[1]);
                  var seat_y_str = $(this).attr('class').split(' ')[2];
                  var y = parseInt(seat_y_str.split('-')[1]);
                  seats_str += x+'_'+y+',';
                }
              });
              $.ajax({
                url:'../order/createOrder',
                data:{sessionId:session_id, seats:seats_str},
                success:function(responseJson) {
                	if (responseJson.status=="fail") {
                		window.location.href= "/" + responseJson.url+"?currentUrl="+window.location.href;
                	} else if (responseJson.status=="create fail") {
                		alert("创建订单失败！")
                	} else if (responseJson.status=="success")	{
                		order_id = responseJson.data.order.id;
                        window.location.href="../order/"+order_id;
                	}
                },
                error:function(XMLHttpRequest, textStatus, errorThrown) {
	            	  alert(XMLHttpRequest.status);
	            	  alert(XMLHttpRequest.readyState);
	            	  alert(textStatus);
                }
              })
            })

            $(".ui.menu .item").tab();
            $(".ui.rating").rating("disable");
        
            $(".ui.modal").modal({
                allowMutiple: false
            });
        
        });
      </script>
    </div>
  </body>
</html>