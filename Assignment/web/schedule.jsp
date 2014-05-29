<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
    <head>
        <title>World Cup 2014</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
        <script type="text/javascript" src="js/jquery-1.4.2.min.js" ></script>
        <script type="text/javascript" src="js/cufon-yui.js"></script>
        <script type="text/javascript" src="js/Humanst521_BT_400.font.js"></script>
        <script type="text/javascript" src="js/Humanst521_Lt_BT_400.font.js"></script>
        <script type="text/javascript" src="js/cufon-replace.js"></script>
        <script type="text/javascript" src="js/roundabout.js"></script>
        <script type="text/javascript" src="js/roundabout_shapes.js"></script>
        <script type="text/javascript" src="js/gallery_init.js"></script>
        <!--[if lt IE 7]>
              <link rel="stylesheet" href="css/ie/ie6.css" type="text/css" media="all">
        <![endif]-->
        <!--[if lt IE 9]>
              <script type="text/javascript" src="js/html5.js"></script>
          <script type="text/javascript" src="js/IE9.js"></script>
        <![endif]-->
    </head>

    <body>
        <!-- header -->
        <header>
            <div class="container">
                <h1><a href="#">World Cup 2014</a></h1>
                <nav>
                    <ul>
                        <li><a href="#">Home</a></li>
                        <li><a href="viewSchedule"  class="current">Schedule</a></li>
                        <li><a href="viewgroup">Group</a></li>
                        <li><a href="#">News</a></li>
                        <li><a href="#">Live</a></li>

                    </ul>
                </nav>
            </div>
        </header>
        <!-- #gallery -->
        <section id="gallery">
            <div class="container">
                <ul id="myRoundabout">
                    <s:set var="f" value="team"/>
                    <s:if test="#f!=0">
                    <li><img src="images/${f}.jpg"></li>
                    </s:if>
                    <s:else>
                        <li><img src="images/1.jpg"></li>
                        <li><img src="images/2.jpg"></li>
                        <li><img src="images/3.jpg"></li>
                        <li><img src="images/13.jpg"></li>
                        <li><img src="images/32.jpg"></li>
                    </s:else>
                </ul>
            </div>
        </section>
        <!-- /#gallery -->
        <div class="main-box">
            <div class="container">
                <div class="inside">
                    <table class="scheduleGroup">
                        <tr>
                            <td>DATE</td>
                            <td>HOME</td>
                            <td></td>
                            <td>AWAY</td>
                            <td>STADIUM</td>
                        </tr>
                        <s:iterator var="m" value="matchs">
                            <tr>
                                <td>${m.date}</td>
                                <td><img src="http://img.fifa.com/images/flags/2/${m.home.code}.png"/> ${m.home.name}</td>
                                <td>${m.kickoff}</td>
                                <td><img src="http://img.fifa.com/images/flags/2/${m.away.code}.png"/> ${m.away.name}</td>
                                <td>${m.venue.name}</td>
                            </tr>
                        </s:iterator>
                    </table>
                </div>
            </div>
        </div>
        <!-- footer -->
        <footer>
            <div class="container">
                <div class="wrapper">
                    <div class="fleft">World Cup 2014</div>
                </div>
            </div>
        </footer>
        <script type="text/javascript"> Cufon.now();</script>
    </body>
</html>
