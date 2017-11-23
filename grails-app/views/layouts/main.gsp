<!doctype html>
<html lang="en" class="no-js">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <title>
      <g:layoutTitle default="Faculife"/>
  </title>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>


  <asset:javascript src="jquery-1.6.3.js"/>

  <!--asset:stylesheet src="application.css"/-->

  <asset:stylesheet src="tooplate_style.css"/>

  <asset:stylesheet src="ddsmoothmenu.css"/>



  <asset:javascript src="ddsmoothmenu.js" />

  <script type="text/javascript">

  ddsmoothmenu.init({
    mainmenuid: "tooplate_menu", //menu DIV id
    orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
    classname: 'ddsmoothmenu', //class added to menu's outer DIV
    //customtheme: ["#1c5a80", "#18374a"],
    contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
  })

  </script>

  <asset:stylesheet src="slimbox2.css"/>

  <asset:javascript src="slimbox2.js" />

  <asset:stylesheet src="nivo-slider.css"/>



  <g:layoutHead/>
</head>
<body>


  <div id="tooplate_header">
      <a href="index.html" class="sitetitle">Education Template</a>
      <div id="tooplate_menu" class="ddsmoothmenu">
          <ul>
              <li><a href="index.html" class="selected">Home</a></li>
              <li><a href="blog.html">Blog</a>
                  <ul>
                      <li><a href="blog.html">Category One</a></li>
                      <li><a href="blog.html">Category Two</a></li>
                      <li><a href="blog.html">Category Three</a></li>
                      <li><a href="blog.html">Category Four</a></li>
                      <li><a href="blog.html">Category Five</a></li>
                  </ul>
              </li>
              <li><a href="gallery.html">Gallery</a>
                  <ul>
                      <li><a href="gallery.html">Web Design</a></li>
                      <li><a href="gallery.html">Flyer</a></li>
                      <li><a href="gallery.html">Icons</a></li>
                  </ul>
              </li>
              <li><a href="about.html">About</a></li>
              <li class="last"><a href="contact.html" class="last">Contact</a></li>
          </ul>
          <br style="clear: left" />
      </div> <!-- end of tooplate_menu -->
  </div> <!-- END of header -->
  <div id="tooplate_slider_wrapper">
      <div id="tooplate_slider">
      	<div class="slider-wrapper theme-default">
              <div id="slider" class="nivoSlider">
                  <asset:image src="/slider/bloque1.png" height="280px"alt="" title="#caption1" />
                  <asset:image src="/slider/02.jpg" alt="" title="#caption2"  />
                  <asset:image src="/slider/03.jpg" alt="" title="#caption3" />
              </div>
              <div id="caption1" class="nivo-html-caption">
              	<h1>Nunca dejes de anotarte!</h1>
                  <p>
  									No dejes de anotarte en las materias más dificiles por falta de horarias, revisalos acá!
  								</p>
              </div>
              <div id="caption2" class="nivo-html-caption">
                  <h1>Calificá a los cursos</h1>
                  <p>
  									Cargale una calificación a tus cursos realizados para ayudarnos entre todos.
  								</p>
              </div>
              <div id="caption3" class="nivo-html-caption">
                  <h1>Analiza tu calendario</h1>
                  <p>Te ayudamos a recomendarte cursos!</p>
              </div>
          </div>
          <div class="button_box">
          	<a href="#" class="button blue">Sign Up</a>
              <a href="#" class="button black">Learn More</a>
          </div>

      <asset:javascript src="jquery-1.6.3.min.js" />

      <asset:javascript src="jquery.nivo.slider.pack.js" />

          <script type="text/javascript">
            $(window).load(function() {
                $('#slider').nivoSlider({
    			effect: 'fade',
    			controlNav: true, // 1,2,3... navigation
                directionNav: false,
    			animSpeed: 800, // Slide transition speed
    	        pauseTime: 6000, // How long each slide will show
    			});
            });
          </script>
      </div> <!-- END of slider -->
  </div>
      <div class="container" id="tooplate_main">
      	<div id="home_about">
          	<h1>Hi, this is Education  Template!</h1>
              <p>Education is free HTML CSS template by <a rel="nofollow" href="http://www.tooplate.com" target="_parent">Tooplate</a>. Vestibulum urna libero, <br />
              <a href="http://www.facebook.com/tooplate" target="_parent">fringilla</a> eu faucibus nec, fringilla eget elit.</p>
          </div>
          <div class="content_wrapper content_mb_60">
          	<div class="col_4">
              <asset:image src="tooplate_image_01.jpg" alt="image" class="img_border img_border_b img_nom"/>
              <p>Maecenas sed quam vitae velit commodo ultricies. Ut vitae luctus mi. Donec ligula dolor aliquam non orci. <a href="#">More...</a></p>
              </div>
              <div class="col_4">
                <asset:image src="tooplate_image_02.jpg"  alt="image" class="img_border img_border_b img_nom"/>

                <p>Cras a orci risus. Nulla scelerisque neque fermentum lorem feugiat fringilla gravida id sed enim. <a href="#">More...</a></p>
              </div>
              <div class="col_4">
                <asset:image src="images/tooplate_image_03.jpg" alt="image" class="img_border img_border_b img_nom"/>
                  <p>Etiam orci velit, lobortis vel tincidunt eu, aliquet vel orci sit amet tellus placerat viverra<a href="#">More...</a></p>
              </div>
              <div class="col_4 no_margin_right">
                <asset:image src="images/tooplate_image_04.jpg" alt="image" class="img_border img_border_b img_nom" />

                <p>Morbi diam est,  et egestas a, aliquet ac quam. Donec vitae augue ut sem cursus aliquet rhoncus vel quam. <a href="#">More...</a></p>
              </div>
          </div>
    		<div class="content_wrapper">
              <div class="col_2">
                  <h2>Lorem Ipsum Dolor</h2>
                  <p><em>Cras mi lectus, tempus vitae venenatis vitae, lobortis in felis eu consequat non,  nec ipsum moestie aliquam diam at lacinia.</em></p>
                  <ul class="list_bullet">
                  	<li class="col_4">Cras mi lectus</li>
                      <li class="col_4">Aliquam erat volutpat</li>
                      <li class="col_4">Vestibulum urna libero</li>
                      <li class="col_4">fringilla eget elit</li>
                      <li class="col_4">Nullam tincidunt</li>
                      <li class="col_4">felis rhoncus rhoncus</li>
                      <li class="col_4">Aliquam blandit nunc</li>
                      <li class="col_4">Suspendisse lobortis</li>
                      <li class="col_4">Aliquam erat</li>
                      <li class="col_4">In eget ligula</li>
                      <li class="col_4">Maecenas vitae eros</li>
                      <li class="col_4"> Nulla pharetra ultricies</li>
                  </ul>
  			</div>

              <div class="col_2 no_margin_right">
                  <h2>Aliquam id Justo Magna</h2>
             	  	<p><em>Credits go to <a rel="nofollow" href="http://webdesign.tutsplus.com/freebies/free-site-elements/exclusive-freebie-the-aristocracy-web-icon-set/" target="_blank">nahas-pro</a> for Icons and <a rel="nofollow" href="http://nivo.dev7studios.com/" target="_blank">dev7studios</a> for the slider. Cras mi lectus, tempus vitae venenatis vitae, lobortis in felis. Duis dapibus, turpis vitae suscipit sagittis, tellus turpis porttitor orci, ut lobortis urna quam at augue.</em></p>
                  <p> Praesent eu neque lectus, ut congue purus. Donec pellentesque, erat vitae tempus volutpat, augue diam pulvinar orci, eget tincidunt felis nibh vel orci. Maecenas semper mi neque. Donec laoreet lorem quis justo auctor mollis. Proin molestie.</p>
                  <a href="#" class="more">More</a>
              </div>
          </div>

          <div class="clear h30"></div>
          <div style="display:none;" class="nav_up" id="nav_up"></div>
      </div>    <!-- END of tooplate_main -->

    <!--g:layoutBody/-->

    <div class="footer" role="contentinfo"></div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>






    <asset:javascript src="scroll-startstop.events.jquery.js"/>

    <script type="text/javascript">
    	$(function() {
    		var $elem = $('#content');

    		$('#nav_up').fadeIn('slow');

    		$(window).bind('scrollstart', function(){
    			$('#nav_up,#nav_down').stop().animate({'opacity':'0.2'});
    		});
    		$(window).bind('scrollstop', function(){
    			$('#nav_up,#nav_down').stop().animate({'opacity':'1'});
    		});

    		$('#nav_up').click(
    			function (e) {
    				$('html, body').animate({scrollTop: '0px'}, 800);
    			}
    		);
    	});
    </script>

</body>
</html>
