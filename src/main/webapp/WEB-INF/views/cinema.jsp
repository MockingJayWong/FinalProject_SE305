<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <link href="../css/lib/semantic/dist/semantic.min.css" rel="stylesheet">
    <link href="../css/cinema.css" rel="stylesheet">
  </head>
  <body>
    <div class="whole">
      <div class="ui main container">
        <nav class="navigator">
          <div class="ui menu"><a href="../html/index.html" class="item">首页</a><a href="../html/login.html" class="item">登陆</a><a href="../html/register.html" class="item">注册</a><a href="../html/user.html" class="item">个人信息</a><a href="../html/orderList.html" class="item">我的订单</a>
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
              <h3>天河电影院</h3>
            </div><img src="../assets/3.jpg" class="cinema-poster poster"/>
            <div class="cinema-rating rating">
              <div data-rating="3" data-max-rating="5" class="ui rating"></div><span class="rating-value">8.8</span>
            </div>
            <dl class="cinema-infos infos">
              <dl class="cinema-address cinema-info info">
                <dt class="label">地址</dt>
                <dd class="value">天河区天河路623号天娱广场5楼（近地铁3号线岗顶站A出口）</dd>
              </dl>
              <dl class="cinema-phone cinema-info info">
                <dt class="label">联系电话</dt>
                <dd class="value">866666666</dd>
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
                <div class="items-content">
                  <div class="item movie-item">
                    <div class="item-title movie-name">魔兽</div>
                    <div class="item-pic movie-poster"><img src="../assets/0.jpg" class="movie-poster poster"/></div>
                    <div class="item-content">
                      <dl class="movie-price movie-info info">
                        <dt class="label">票价</dt>
                        <dd class="value">35</dd>
                      </dl>
                      <dl class="movie-section movie-info info">
                        <dt class="label">场次</dt>
                        <dd class="value">13:10 | 13:45 | 14:50 | 15:30 | 16:30 | 17:15 |18:10 | 19:00 | 19:50 | 20:40 |21:30 | 22:25</dd>
                      </dl>
                    </div>
                    <div class="item-button"><a href="#">
                        <button class="ui primary button purchase-btn">选座购票</button></a></div>
                  </div>
                  <div class="item movie-item">
                    <div class="item-title movie-name">魔兽</div>
                    <div class="item-pic movie-poster"><img src="../assets/0.jpg" class="movie-poster poster"/></div>
                    <div class="item-content">
                      <dl class="movie-price movie-info info">
                        <dt class="label">票价</dt>
                        <dd class="value">35</dd>
                      </dl>
                      <dl class="movie-section movie-info info">
                        <dt class="label">场次</dt>
                        <dd class="value">13:10 | 13:45 | 14:50 | 15:30 | 16:30 | 17:15 |18:10 | 19:00 | 19:50 | 20:40 |21:30 | 22:25</dd>
                      </dl>
                    </div>
                    <div class="item-button"><a href="#">
                        <button class="ui primary button purchase-btn">选座购票</button></a></div>
                  </div>
                  <div class="item movie-item">
                    <div class="item-title movie-name">魔兽</div>
                    <div class="item-pic movie-poster"><img src="../assets/0.jpg" class="movie-poster poster"/></div>
                    <div class="item-content">
                      <dl class="movie-price movie-info info">
                        <dt class="label">票价</dt>
                        <dd class="value">35</dd>
                      </dl>
                      <dl class="movie-section movie-info info">
                        <dt class="label">场次</dt>
                        <dd class="value">13:10 | 13:45 | 14:50 | 15:30 | 16:30 | 17:15 |18:10 | 19:00 | 19:50 | 20:40 |21:30 | 22:25</dd>
                      </dl>
                    </div>
                    <div class="item-button"><a href="#">
                        <button class="ui primary button purchase-btn">选座购票</button></a></div>
                  </div>
                  <div class="item movie-item">
                    <div class="item-title movie-name">魔兽</div>
                    <div class="item-pic movie-poster"><img src="../assets/0.jpg" class="movie-poster poster"/></div>
                    <div class="item-content">
                      <dl class="movie-price movie-info info">
                        <dt class="label">票价</dt>
                        <dd class="value">35</dd>
                      </dl>
                      <dl class="movie-section movie-info info">
                        <dt class="label">场次</dt>
                        <dd class="value">13:10 | 13:45 | 14:50 | 15:30 | 16:30 | 17:15 |18:10 | 19:00 | 19:50 | 20:40 |21:30 | 22:25</dd>
                      </dl>
                    </div>
                    <div class="item-button"><a href="#">
                        <button class="ui primary button purchase-btn">选座购票</button></a></div>
                  </div>
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
                    <tbody class="reco-sections">
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
                  <!-- temporary--><a href="order.html">
                    <button class="ui primary button purchase-btn">去支付</button></a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
    <script src="../css/lib/semantic/dist/semantic.min.js"></script>
    <script type="text/javascript">
      $(document).ready(function(){
          $(".ui.menu .item").tab();
          $(".ui.rating").rating("disable");
      
          $(".ui.modal").modal({
              allowMutiple: false
          });
      
          $(".movie-item .purchase-btn").click(function(e) {
              $(".first.modal").modal("show");
          })
          $(".second.modal").modal("attach events", ".first.modal .button");
          
          
          
          $.ajax({
        	  url:'detail'
          })
          
      });
    </script>
  </body>
</html>