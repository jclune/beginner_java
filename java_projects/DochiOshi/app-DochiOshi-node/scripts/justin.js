/*
 * dochioshi
 *
 * Copyright (c) 2014 Justin Clune
 */
(function($, window, document) {
    $(function() {
        //-----------------GET THE PHOTOS!-----------------
        var $flickr = $(".flickr");
        var options = {};
        options.url = 'https://api.flickr.com/services/rest/';
        options.method = 'GET';
        options.params = {
            method: 'flickr.photos.search',
            per_page: $flickr.length,
            text: 'puppy',
            api_key: '3e53c0f0f82059213050c4e8f2ad111d',
            format: 'json',
            nojsoncallback: 1
        };

        function requestSearch(options) {
            console.log("start ajax with search: " + options.params.text);
            $.ajax({
                type: options.method,
                url: options.url,
                data: options.params,
            }).done(function(data) {
                getPhotos(data);
            }).error(function() {
                var h2 = document.createElement("h2");
                h2.innerHTML = "API error";
                document.getElementById("container").appendChild(h2);
            });
        }
        requestSearch(options);

        function getPhotos(data) {
            var count = 0;
            // get the photo array and append images. reset if theres an old arrray
            var photos = data.photos.photo;
            photos.forEach(function(i) {

                console.log(options.params.text);
                var img = $flickr[count++];

                img.src = "http://farm" + i.farm + ".staticflickr.com/" +
                    i.server + "/" + i.id + "_" + i.secret + "_z.jpg";
            });
        }
        //--------jQuery UI functions---------------
        var icons = {
            header: "glyphicon glyphicon-arrow-down",
            activeHeader: "glyphicon glyphicon-arrow-up"
        };
        var icons2 = {
            header: "glyphicon glyphicon-arrow-down",
            activeHeader: ""
        };
        $('.accordionCol').accordion({
            active: false,
            collapsible: true,
            icons: icons
        });
        $('.accordion').accordion({
            icons: icons2,
            heightStyle: "content"
        });
        var radioCount = 0;
        $('.categoryButton').click(function(event) {
            //clear all radios
            $('input[type="radio"]:checked').prop('checked', false);
            $('.categoryButton').removeClass("pure-button-primary");

            var $btn = $(this);
            var $radio = $btn.find('input[type="radio"]');
            $btn.addClass("pure-button-primary");
            $radio.prop("checked", true);
            //toggle versio is commented out
            // $radio.prop("checked", !$radio.prop("checked"));
            $('input[type="radio"]:checked').each(function() {
                console.log($(this).attr('name') + " is checked");
                radioCount++;
                // if (radioCount === 1) {
                //     $('.accordion').accordion("option", "active", 1);
                // }
            });
            $(".ui-accordion-content").show();
            event.preventDefault();
        });
        var h3Count = 0;
        $('.accordionCss > h3').click(function() {
            console.log("accordion click #: " + h3Count++);
            $(".ui-accordion-content").show();
        });
        $(".qsABobj").click(function() {
            $(".stamp").hide();
            $(this).find(".stamp").show();
            // $(this).find(".stamp").attr("src", "${pageContext.request.contextPath}/resources/app/images/stamp.png");
        });
    });

}(window.jQuery, window, document));