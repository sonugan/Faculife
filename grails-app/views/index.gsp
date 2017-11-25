<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
  <div id="tooplate_slider_wrapper">
    <div id="tooplate_slider">
      <div class="slider-wrapper theme-default">
            <div id="slider" class="nivoSlider">
                <asset:image src="/slider/bloque1.png" height="280px"alt="" title="#caption1" />
                <asset:image src="/slider/02.jpg" alt="" title="#caption2"  />
                <asset:image src="/slider/03.jpg" alt="" title="#caption3" />
            </div>
            <div id="caption1" class="nivo-html-caption">
              <h1>Planifica tu cursada</h1>
                <p>
                  No dejes de anotarte en las materias más dificiles por falta de horarios.
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
</body>
</html>
