<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <link href="../resources/css/lib/semantic/dist/semantic.min.css" rel="stylesheet">
    <link href="../resources/css/cinema.css" rel="stylesheet">
  </head>
  <body>
    <div class="whole">
      <div class="ui main container">
        <nav class="navigator">
          <div class="ui menu">
            <a href="../" class="item">首页</a>
            <a href="../account/login" class="item">登陆</a>
            <a href="../account/register" class="item">注册</a>
            <a href="../account/user/orderList" class="item">我的订单</a>
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
          <div class="cinema-intro detail-intro">
            <div class="cinema-title title">
              <h3 id='cinema_name'>天河电影院</h3>
            </div><img src="../assets/3.jpg" class="cinema-poster poster"/>
            <div class="cinema-rating rating">
              <div data-rating="3" data-max-rating="5" class="ui rating"></div><span class="rating-value">8.8</span>
            </div>
            <dl class="cinema-infos infos">
              <dl class="cinema-address cinema-info info">
                <dt class="label">地址</dt>
                <dd id='cinema_address' class="value">天河区天河路623号天娱广场5楼（近地铁3号线岗顶站A出口）</dd>
              </dl>
              <dl class="cinema-phone cinema-info info">
                <dt class="label">联系电话</dt>
                <dd id='cinema_phone' class="value">866666666</dd>
              </dl>
              <dl class="cinema-time cinema-info info">
                <dt class="label">营业时间</dt>
                <dd class="value">9:00-24:00</dd>
              </dl>
            </dl>
          </div><a name="movies"></a>
          <div class="tab-container">
            <div class="ui attached tabular menu reco-movies"><a data-tab="movies" class="item active">电影</a><a data-tab="recommends" class="item">影院评价</a>
            </div>
            <div data-tab="movies" class="ui tab attached segment active">
              <div class="items-container reco-movies">
                <div class="title">
                  <h4>热映电影</h4>
                </div>
                <div id='movies' class="items-content">

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
                    <tbody id='sessions_tbody' class="reco-sections">
                      
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
                    <button id="generate_order_btn" class="ui primary button purchase-btn">去支付</button>
                </div>
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
        $(".ui.menu .item").tab();
        $(".ui.rating").rating("disable");
    
        $(".ui.modal").modal({
            allowMutiple: false
        });
        
        
        // 从url获取cinemaId
        var url = window.location.href;
        var temp_array =  url.split('/');
        var cinema_id = temp_array[temp_array.length-1].split('#')[0];

        $.ajax({
          url:'detail',
          data:{cinemaId:cinema_id},
          success: function(responseJson) {
            var status = responseJson.status;
            switch(status) {
              case "success":
                var cinema = responseJson.data.cinema;
                $('#cinema_name').html(cinema.cinemaName);
                $('#cinema_address').html(cinema.address);
                $('#cinema_phone').html(cinema.phone);
                break;
              default:
                break;
            }
          }
        });

        var movie_id_map = {};
        $.ajax({
          url:'movieList',
          data:{cinemaId:cinema_id},
          success: function(responseJson) {
            var status = responseJson.status;
            var movie_html = 
                '<div class="item movie-item">\
                  <div class="item-title movie-name">魔兽</div>\
                  <div class="item-pic movie-poster"><img src="../resources/images/url" class="movie-poster poster"/></div>\
                  <div class="item-content">\
                    <dl class="movie-price movie-info info">\
                      <dt class="label">票价</dt>\
                      <dd class="value">35</dd>\
                    </dl>\
                    <dl class="movie-section movie-info info">\
                      <dt class="label">场次</dt>\
                      <dd class="value">sessions</dd>\
                    </dl>\
                  </div>\
                  <div class="item-button">\
                      <button id="movie_btn_movie_id" class="ui primary button purchase-btn">选座购票</button></div>\
                </div>'
            switch(status) {
              case "success":
                var movies_html = '';
                var movieList = responseJson.data.list;
                for (var movieIndex in movieList) {
                  var movie = movieList[movieIndex];
                  movie_id_map[movie.id] = movie;
                  var session_str = '';
                  var sessions = movie.sessions;
                  for (var sessionIndex in sessions) {
                    if (sessionIndex != 0) session_str += '| ';
                    var session = sessions[sessionIndex];
                    var start_time = new Date(session.start_time);
                    session_str += start_time.getHours()+':'+start_time.getMinutes()+' ';
                  }

                  movies_html += movie_html.replace('35', movie.sessions[0].price).replace('魔兽', movie.movieName).replace('url', movie.url).replace('sessions', session_str).replace('movie_id', movie.id);
                }
                $('#movies').html(movies_html);
                $(".movie-item .purchase-btn").click(select_session);
                break;
              default:
                break;
            }
          },
          error:function(XMLHttpRequest, textStatus, errorThrown) {
              alert(XMLHttpRequest.status);
              alert(XMLHttpRequest.readyState);
              alert(textStatus);
            }
        });

        function select_session(e) {
          var movie_id = e.target.id.split('_')[2];
          var session_list = movie_id_map[movie_id].sessions;

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
                var seat_x = sold_list[seatIndex][0];
                var seat_y = sold_list[seatIndex][1];
                $('.row-'+seat_x).filter('.col-'+seat_y).attr("checked","checked").attr("disabled", "disabled");
              }
              $(".second.modal").modal("show");
            }
          });
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
              } else if (responseJson.status=="success")  {
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
      });
    </script>
  </body>
</html>