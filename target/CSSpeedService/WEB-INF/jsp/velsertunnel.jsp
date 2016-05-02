<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>DiTTlab</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
    </head>
    <body>
        <a href="index.html"><img id="homeButton" class="topcorner1"  src="images/home.png"></a>
        <img input style="height: 6%;margin-right: 4%; visibility: hidden" class="hiddendiv topcorner_reversed" id="backbutton" border="2" src="images/back.png" onclick="backButton()">
        
        
        <div class="logo"><a href="http://dittlab.tudelft.nl/"><img class="fit1" src="images/logo.png" /></a></div>
        
        <div class="mapcontainer" style="height:100%">
            <div class="mapstyle" id="mapdiv"></div>
        </div>
        
        <div id="floatingboxcontainer" style="position:absolute; top: 30%; width: 384px;">
            <div id="time-control" style="position:absolute; top:30%; width:300px; background:whitesmoke; padding:3%;">
                <button style="margin: 0px; color: red; font-size: 1.5em; float:right" onclick="timeSliderFloatingboxOptions.floatingBox.cancelButton()">X</button>
                <div id="time-range">
                    <p>Time: <input type="text" id="slider-time" size="10" value="--:-- AM/PM"></p>
                    <div class="ui-slider">
                        <div id="slider"></div>
                    </div>
                </div>  
                <button class="clickablePlayButton" onclick="sliderOptions.singleTimeSlider.playAnimation(0.01, 1)">
                    <img style="width:30px; height:30px;" src="images/play_icon.png">
                </button>
                <button style="position:relative; left:70%; color:black; font-size:1.5em;" onclick="sliderOptions.singleTimeSlider.CancelButton();">Cancel</button>
            </div>
        </div>
        
        <div id="arrow" class="hiddendiv" style="top:30%;" onclick="timeSliderFloatingboxOptions.floatingBox.arrowButton()"></div>
        
       
        
        
        <form id="layer_selection" style="background: whitesmoke; position: absolute; bottom: 10%; padding: 10px; font-size: 1.5em; color: black;" method="post">
            <p>Layer Selection</p>
            <input type="checkbox" name="dispParking" value="Bike" checked> Parking Data<br>
            <input type="checkbox" name="dispTrains" value="Car" checked> Train Lines<br>
            <input type="checkbox" name="dispDrips" value="Car" checked> DRIP Data<br>
        </form>
        
        
        
        <div id="rightpanel" class="hiddendiv" style="visibility: hidden;">
            <div style="height: 8%; background-color: #C4C4A7">
                <input id="raw" type="image" style="width:10%" class="fit" src="images/raw1.png" />
                <input id="asm" type="image" style="width:10%" class="fit" src="images/filter.png" />
                <input id="tt" type="image" style="width:10%" class="fit" src="images/tt1.png" />
                <input id="stats" type="image" style="width:10%" class="fit" src="images/stats.png"/>
                <input id="weatherbutton" type="image" style="width:10%; margin-left: 1%;" class="fit" src="images/weather.png"/>
                <a style="width:10%"><input id="download" type="image" style="width:8%; opacity: 0.7; margin-left: 1%; margin-bottom: 0.5%;" class="fit1" src="images/download.png" onclick=""></a>
            </div>
            <div>
                <div style="height: 2%; background: white;"></div>

                <div id="plots" style="height: 90%; background: white; color: white;">
                    <div id="divLoading"></div>
                    <div style="font-family: Courier New,Courier; margin-left: 10%; display: none;" class="title" id="hiddendiv"></div>
                    <div>
                        <div id="upperdiv"></div>
                        <div style="display: none; top: 10%; left: 0;position: absolute; z-index: 10; opacity: 0.3;" id="weatherdiv"></div>
                    </div>
                    <div id="lowerdiv"></div>
                </div>
            </div>
        </div>
        

        <div id="dateTimePickerDiv" style="background: whitesmoke; position: absolute; bottom: 1%; padding: 10px; font-size: 1.5em; color: black;" method="post" ></div>
        
        
        <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"/>
        <!--<link rel="stylesheet" type="text/css" href="css/jquery-clockpicker.min.css"/>-->
        <link rel="stylesheet" href="css/leaflet.css" />
        <link rel="stylesheet" href="css/leaflet-routing-machine.css" />
        <link rel="stylesheet" href="css/style.css" type="text/css" />
        <link rel="stylesheet" href="css/leaflet-PolylineDecorator.css"/>
        <link rel="stylesheet" href="css/velsertunnel.css" type="text/css" />        
        <link rel="stylesheet" href="css/UI_1.10.3-timeslider.css" type="text/css" />
        <link rel="stylesheet" href="css/jquery.timepicker.css" />
                
        <script src="http://cdn.leafletjs.com/leaflet-0.7.5/leaflet.js"></script>
        <script type="text/javascript" src="js/leaflet-routing-machine.js"></script>
        <script src="http://api.tiles.mapbox.com/mapbox.js/plugins/turf/v2.0.0/turf.min.js"></script>
        <script type="text/javascript" src="js/dependencies/d3.v3.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
        <script src="http://www.openlayers.org/api/OpenLayers.js"></script>
       
        <script type="text/javascript" src="js/jquery.timepicker.min.js"></script>
        <script type="text/javascript" src="js/jquery.datepair.js"></script>
        <script type="text/javascript" src="js/Datepair.js"></script>
        <script type="text/javascript" src="js/DateTimePicker.js"></script>
        
        <script type="text/javascript" src="js/floatingboxOptions.js"></script>
        <script type="text/javascript" src="js/mapProperties.js"></script> 
        <script type="text/javascript" src="js/existingLayers.js"></script>
        <script type="text/javascript" src="js/parkingLayerTools.js"></script> 
        <script type="text/javascript" src="js/singleSliderInitialization.js"></script>
        <script type="text/javascript" src="js/singleSlider.js"></script>
        <script type="text/javascript" src="js/trainLineTools.js"></script>
        <script type="text/javascript" src="js/dripTools.js"></script>
        <script type="text/javascript" src="js/layers.js"></script>
        <script type="text/javascript" src="js/leaflet.polylineDecorator.js"></script>
        <script type="text/javascript" src="js/leaflet.polylineoffset.js"></script>
        <script type="text/javascript" src="https://cdn.plot.ly/plotly-latest.min.js"></script>
        <script type="text/javascript" src="js/panelTools.js"></script>
        <!--<script type="text/javascript" src="js/jquery-clockpicker.min.js"></script>-->
        
        <script>
            /* To switch to the velsertunnel data this file, velsertunnel.jsp, is 
            * called from the index.html.
            * The velsertunnel data layers are added to and removed from the map 
            * (OpenStreetMap) based on user selection. 
            * The variable 'layers.existingLayers' contains the data-layers that will 
            * be added to the map.
            * Initialization of the visualisation of the data as well as the 
            * animation of data is coordinated from the layer_selection function 
            * (see below) and the singleSlider.js file.
            */
           
            // DateTimePicker
            var chooseDateTime = DateTimePicker();
            
            // tileLayer: Open Street Map
            var mapProperties   = new mapProperties(); 
            var map             = mapProperties.map; 

            // Floating box
            var timeSliderFloatingboxOptions = new timeSliderFloatingboxOptions();
            
            // Time slider
            var sliderOptions = new singleSliderInitialization();    
           
            // Introduce data layers and corresponding functions
            var layers = new introduceLayers();
 
            // Initialize the visualizations
            sliderOptions.singleTimeSlider.init();
            
            
            
        </script>
    </body>
</html>