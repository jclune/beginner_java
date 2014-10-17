/*
 * dochioshi
 *
 * Copyright (c) 2014 Justin Clune
 */
(function($, window, document) {
    $(function() {
        //-----------------GET FLICKR PHOTOS!-----------------
        var $flickr = $(".flickr");
        console.log($flickr);
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
            if ($flickr.length > 0) {
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
            } else {
                console.log("no flickr photos");
            }
        }
        requestSearch(options);

        function getPhotos(data) {
            // get the photo array and append images. reset if theres an old arrray
            var photos = data.photos.photo;
            photos.forEach(function(photo, i) {

                var img = $flickr[i];

                img.src = "http://farm" + photo.farm + ".staticflickr.com/" +
                    photo.server + "/" + photo.id + "_" + photo.secret + "_z.jpg";
            });
        }



        //------------------jQuery UI functions---------------
        var icons = {
            header: "glyphicon glyphicon-circle-arrow-down",
            activeHeader: "glyphicon glyphicon-circle-arrow-up"
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
            $('input[type="radio"]:checked').each(function() {
                console.log("radio #" + $(this).attr('value') + " is checked");
                radioCount++;

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
        });

        var $AB = $('.ABfile');
        console.log($('.ABfile'));
        console.log("console works again!");




        //-----------------GET THE UPLOADED PHOTOS!-----------------
        $('.ABfile').change(function() {
            var $this = $(this);
            if ($this.prop('files').length > 0) {
                console.log($this.prop('files'));
                var file = $this.prop('files')[0];
                var fr = new FileReader();
                fr.onload = function() {
                    $this.parent().parent().find('.ABimg').attr('src', fr.result);
                };
                fr.readAsDataURL(file);
            } else {
                console.log("changed input but didn't select file");
            }
        });




        //-----------------AJAX FUNCTIONS!-----------------
        $('.addComment').on("click", function(event) {
            event.stopPropagation();
            var $comments = $(this).parent().parent().parent().find('.qsComments');
            var $input = $(this).parent().parent().find('.comment').val();
            var $accordion = $(this).parent().parent().parent().find('div.qsAccordion');
            var $liHeight = $comments.children().first().outerHeight();
            $.ajax({
                type: "post",
                url: "post/comment",
                cache: false,
                data: 'content=' + $input + '&question_id=1',
                dataType: "json",
                success: function(response) {
                    $accordion.css("height", "+=" + $liHeight);
                    $comments.append('<li class="qsComment  clearfix">' +
                        '<div style="min-height: 30px;"><img src="/dochioshi/resources/app/images/icon.png" alt="" class="qsProfileImg flickr"></div>' +
                        '<span class="qsCommentAuthor"><a>Me</a></span><span>' +
                        $input +
                        '</span></li>');
                    console.log($comments);
                    console.log(response);
                },
                error: function() {
                    console.log('Error while request..');
                }
            });
        });
        $('.testAddComment').on("click", function(event) {
            event.stopPropagation();
            var $comments = $(this).parent().parent().parent().find('.qsComments');
            var $input = $(this).parent().parent().find('.comment').val();
            var $accordion = $(this).parent().parent().parent().find('div.qsAccordion');
            var $liHeight = $comments.children().first().outerHeight();
            $accordion.css("height", "+=" + $liHeight);
            $comments.append('<li class="qsComment  clearfix">' +
                '<div><img src="/dochioshi/resources/app/images/icon.png" alt="" class="qsProfileImg flickr"></div>' +
                '<span class="qsCommentAuthor"><a>Me</a></span><span>' +
                $input +
                '</span></li>');
        });
    });
}(window.jQuery, window, document));