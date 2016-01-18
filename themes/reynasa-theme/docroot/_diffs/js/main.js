AUI().ready(
	'liferay-navigation-interaction',
	'liferay-sign-in-modal',
	'anim',
	'transition',
	function(A) {
		
		// Política de Cookies
		var cookie_key = "show_msg_cookies";
		
		 if (existsCookie(cookie_key)) { // Si ya habíamos aceptado la  política de cookies
				document.cookie = cookie_key + "=false;path=/"; // Creamos una cookie propia  para marcar que el usuario ha aceptado la política
				var alertCookies = A.one('#alertCookies');
				alertCookies.setStyle('display', 'none');
		 } else {
			 var alertCookies = A.one('#alertCookies');
			 alertCookies.setStyle('display','block');
		
			 // Si pasamos el tiempo de espera cargamos las cookies igualmente
			
			 window.setTimeout(function(){
					document.cookie = cookie_key + "=false;path=/"; // Creamos una cookie propia  para marcar que el usuario ha aceptado la política
					var alertCookies = A.one('#alertCookies');
					alertCookies.setStyle('display', 'none');
			
			 }, 60000);
		
		 }
					
		
		 // Función auxiliar que comprueba que una determinada cookie exista
		function existsCookie(cname) {

			var name = cname + "=";

			var ca = document.cookie.split(';');

			for (var i = 0; i < ca.length; i++) {

				var c = ca[i].trim();

				if (c.indexOf(name) == 0)
					return true;

			}

			return false;

		}

		// Aquí se define las acciones a realizar a la hora de aceptar la
		// política
		A.one('#acceptCookies').on('click',

		function(event) {
			document.cookie = cookie_key + "=false;path=/"; // Creamos una cookie propia  para marcar que el usuario ha aceptado la política
			var alertCookies = A.one('#alertCookies');
			alertCookies.setStyle('display', 'none');
			
			// loadCookies(); // Ya podemos cargar la cookies
		}

		);

		// Fin de política de cookies
		
		
		var Lang = A.Lang;

		var BODY = A.getBody();

		var WIN = A.getWin();

		var navigation = A.one('#navigation');

		if (navigation) {
			navigation.plug(Liferay.NavigationInteraction);
		}

		var signIn = A.all('.sign-in a');

		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}

		// Scroll animate to hash

		A.all('.scroll-animate').on(
			'click',
			function(animScroll) {
				var instance = this;

				var node = animScroll.currentTarget;
				var section = A.one(node.get('hash'));

				if (section) {
					instance.removeClass('aactive');
					node.addClass('aactive');

					var scrollTo = Lang.toInt(section.getY());
					animScroll.preventDefault();

					new A.Anim(
						{
							duration: 0.8,
							easing: 'easeBoth',
							node: 'win',
							to: {
								scroll: [0, scrollTo]
							}
						}
					).run();
				}
			}
		);

		// Arrow top

		var winHeight = WIN.get('innerHeight');

		if (Lang.isUndefined(winHeight)) {
			winHeight = document.documentElement.clientHeight;
		}

		var displayBannerHeight = function() {
			var currentScrollPos = WIN.get('docScrollY');

			if (currentScrollPos >= winHeight) {
				BODY.addClass('arrow-top-visible');
			}
			else {
				BODY.removeClass('arrow-top-visible');
			}
		};

		displayBannerHeight();

		A.on('resize', displayBannerHeight);
		A.on('scroll', displayBannerHeight);

	}
);

//Pagination

(function($){
	$.fn.easyPaginate = function (options) {
	    var defaults = {
	        paginateElement: 'a',
	        hashPage: 'page',
	        elementsPerPage: 5,
	        effect: 'default',
	        slideOffset: 200,        
	        prevButton: true,
	        prevButtonText: '<',        
	        nextButton: true,
	        nextButtonText: '>',        
	        onSomeEvent: function() {}
	    }
	        
	    return this.each (function (instance) {        
	        
	        var plugin = Object;
	        plugin.el = $(this);
	        plugin.el.addClass('easyPaginateList');
	        plugin.el.addClass('span12');

	        plugin.settings = {
	            pages: 0,
	            objElements: Object,
	            currentPage: 1
	        }
	        
	        var getNbOfPages = function() {
	            return Math.ceil(plugin.settings.objElements.length / plugin.settings.elementsPerPage);         
	        };
	        
	        var displayNav = function() {
	            htmlNav = '<div class="easyPaginateNav">';
	            
	            if(plugin.settings.firstButton) {
	                htmlNav += '<a href="#'+plugin.settings.hashPage+':1" title="First page" rel="1" class="first">'+plugin.settings.firstButtonText+'</a>';
	            }
	            
	            if(plugin.settings.prevButton) {
	                htmlNav += '<a href="" title="Previous" rel="" class="prev">'+plugin.settings.prevButtonText+'</a>';
	            }
	            
	            
	            if(plugin.settings.nextButton) {
	                htmlNav += '<a href="" title="Next" rel="" class="next">'+plugin.settings.nextButtonText+'</a>';
	            }
	            
	            if(plugin.settings.lastButton) {
	                htmlNav += '<a href="#'+plugin.settings.hashPage+':'+plugin.settings.pages+'" title="Last page" rel="'+plugin.settings.pages+'" class="last">'+plugin.settings.lastButtonText+'</a>';
	            }
	            
	            htmlNav += '</div>';
	            plugin.nav = $(htmlNav);
	            
	            plugin.el.after(plugin.nav);
	            
	            $('.easyPaginateNav a.page, .easyPaginateNav a.first, .easyPaginateNav a.last', plugin).live('click', function(e) {                
	                e.preventDefault();
	                displayPage($(this).attr('rel'));                
	            });
	            
	            $('.easyPaginateNav a.prev', plugin).live('click', function(e) {                
	                e.preventDefault();
	                page = plugin.settings.currentPage > 1?parseInt(plugin.settings.currentPage) - 1:1;
	                displayPage(page);
	            });
	            
	            $('.easyPaginateNav a.next', plugin).live('click', function(e) {                
	                e.preventDefault();
	                page = plugin.settings.currentPage < plugin.settings.pages?parseInt(plugin.settings.currentPage) + 1:plugin.settings.pages;
	                displayPage(page);
	            });
	        };
	        
	        var displayPage = function(page, forceEffect) {
	            if(plugin.settings.currentPage != page) {
	                plugin.settings.currentPage = parseInt(page);
	                offsetStart = (page - 1) * plugin.settings.elementsPerPage;
	                offsetEnd = page * plugin.settings.elementsPerPage;
	                if(typeof(forceEffect) != 'undefined') {
	                    eval("transition_"+forceEffect+"("+offsetStart+", "+offsetEnd+")");
	                }else {
	                    eval("transition_"+plugin.settings.effect+"("+offsetStart+", "+offsetEnd+")");
	                }
	                
	                plugin.nav.find('.current').removeClass('current');
	                plugin.nav.find('a.page:eq('+(page - 1)+')').addClass('current');
	                
	                switch(plugin.settings.currentPage) {
	                    case 1:
	                        $('.easyPaginateNav a', plugin).removeClass('disabled');
	                        $('.easyPaginateNav a.first, .easyPaginateNav a.prev', plugin).addClass('disabled');
	                        break;
	                    case plugin.settings.pages:
	                        $('.easyPaginateNav a', plugin).removeClass('disabled');
	                        $('.easyPaginateNav a.last, .easyPaginateNav a.next', plugin).addClass('disabled');
	                        break;
	                    default:
	                        $('.easyPaginateNav a', plugin).removeClass('disabled');
	                        break;
	                }
	            }
	        };
	        
	        var transition_default = function(offsetStart, offsetEnd) {
	            plugin.currentElements.hide();
	            plugin.currentElements = plugin.settings.objElements.slice(offsetStart, offsetEnd).clone();
	            plugin.el.html(plugin.currentElements);
	            plugin.currentElements.show();
	        };
	        
	        var transition_fade = function(offsetStart, offsetEnd) {
	            plugin.currentElements.fadeOut();
	            plugin.currentElements = plugin.settings.objElements.slice(offsetStart, offsetEnd).clone();
	            plugin.el.html(plugin.currentElements);
	            plugin.currentElements.fadeIn();
	        };
	        
	        var transition_slide = function(offsetStart, offsetEnd) {
	            plugin.currentElements.animate({
	                'margin-left': plugin.settings.slideOffset * -1,
	                'opacity': 0
	            }, function() {
	                $(this).remove();
	            });
	            
	            plugin.currentElements = plugin.settings.objElements.slice(offsetStart, offsetEnd).clone();
	            plugin.currentElements.css({
	                'margin-left': plugin.settings.slideOffset,
	                'display': 'block',
	                'opacity': 0,
	                'min-width': plugin.el.width() / 2
	            });
	            plugin.el.html(plugin.currentElements);
	            plugin.currentElements.animate({
	                'margin-left': 0,
	                'opacity': 1
	            });
	        };
	                
	        var transition_climb = function(offsetStart, offsetEnd) {            
	            plugin.currentElements.each(function(i) {
	                var $objThis = $(this);
	                setTimeout(function() {
	                    $objThis.animate({
	                        'margin-left': plugin.settings.slideOffset * -1,
	                        'opacity': 0
	                    }, function() {
	                        $(this).remove();
	                    });
	                }, i * 200);
	            });
	            
	            plugin.currentElements = plugin.settings.objElements.slice(offsetStart, offsetEnd).clone();
	            plugin.currentElements.css({
	                'margin-left': plugin.settings.slideOffset,
	                'display': 'block',
	                'opacity': 0,
	                'min-width': plugin.el.width() / 2
	            });
	            plugin.el.html(plugin.currentElements);
	            plugin.currentElements.each(function(i) {
	                var $objThis = $(this);
	                setTimeout(function() {
	                    $objThis.animate({
	                        'margin-left': 0,
	                        'opacity': 1
	                    });
	                }, i * 200);
	            });
	        };
	                
	        plugin.settings = $.extend({}, defaults, options);
	        
	        plugin.currentElements = $([]);
	        plugin.settings.objElements = plugin.el.find(plugin.settings.paginateElement);
	        plugin.settings.pages = getNbOfPages();
	        if(plugin.settings.pages > 1) {
	            plugin.el.html();
	    
	            // Here we go
	            displayNav();
	            
	            page = 1;
	            if(document.location.hash.indexOf('#'+plugin.settings.hashPage+':') != -1) {
	                page = parseInt(document.location.hash.replace('#'+plugin.settings.hashPage+':', ''));
	                if(page.length <= 0 || page < 1 || page > plugin.settings.pages) {
	                    page = 1;
	                }
	            }
	            
	            displayPage(page, 'default');
	        }
	    });
	};
	})(jQuery);




//Pagination Noticias y Promociones

(function($){
	$.fn.easyPaginateNoticias = function (options) {
	    var defaults = {
	        paginateElement: 'span',
	        hashPage: 'page',
	        elementsPerPage: 6,
	        effect: 'default',
	        slideOffset: 200,        
	        prevButton: true,
	        prevButtonText: '<',        
	        nextButton: true,
	        nextButtonText: '>',        
	        onSomeEvent: function() {}
	    }
	        
	    return this.each (function (instance) {        
	        
	        var plugin = Object;
	        plugin.el = $(this);
	        plugin.el.addClass('easyPaginateList');
	        plugin.el.addClass('span12');

	        plugin.settings = {
	            pages: 0,
	            objElements: Object,
	            currentPage: 1
	        }
	        
	        var getNbOfPages = function() {
	            return Math.ceil(plugin.settings.objElements.length / plugin.settings.elementsPerPage);         
	        };
	        
	        var displayNav = function() {
	            htmlNav = '<div class="easyPaginateNav">';
	            
	            if(plugin.settings.firstButton) {
	                htmlNav += '<a href="#'+plugin.settings.hashPage+':1" title="First page" rel="1" class="first">'+plugin.settings.firstButtonText+'</a>';
	            }
	            
	            if(plugin.settings.prevButton) {
	                htmlNav += '<a href="" title="Previous" rel="" class="prev">'+plugin.settings.prevButtonText+'</a>';
	            }
	            
	            
	            if(plugin.settings.nextButton) {
	                htmlNav += '<a href="" title="Next" rel="" class="next">'+plugin.settings.nextButtonText+'</a>';
	            }
	            
	            if(plugin.settings.lastButton) {
	                htmlNav += '<a href="#'+plugin.settings.hashPage+':'+plugin.settings.pages+'" title="Last page" rel="'+plugin.settings.pages+'" class="last">'+plugin.settings.lastButtonText+'</a>';
	            }
	            
	            htmlNav += '</div>';
	            plugin.nav = $(htmlNav);
	            
	            plugin.el.after(plugin.nav);
	            
	            $('.easyPaginateNav a.page, .easyPaginateNav a.first, .easyPaginateNav a.last', plugin).live('click', function(e) {                
	                e.preventDefault();
	                displayPage($(this).attr('rel'));                
	            });
	            
	            $('.easyPaginateNav a.prev', plugin).live('click', function(e) {                
	                e.preventDefault();
	                page = plugin.settings.currentPage > 1?parseInt(plugin.settings.currentPage) - 1:1;
	                displayPage(page);
	            });
	            
	            $('.easyPaginateNav a.next', plugin).live('click', function(e) {                
	                e.preventDefault();
	                page = plugin.settings.currentPage < plugin.settings.pages?parseInt(plugin.settings.currentPage) + 1:plugin.settings.pages;
	                displayPage(page);
	            });
	        };
	        
	        var displayPage = function(page, forceEffect) {
	            if(plugin.settings.currentPage != page) {
	                plugin.settings.currentPage = parseInt(page);
	                offsetStart = (page - 1) * plugin.settings.elementsPerPage;
	                offsetEnd = page * plugin.settings.elementsPerPage;
	                if(typeof(forceEffect) != 'undefined') {
	                    eval("transition_"+forceEffect+"("+offsetStart+", "+offsetEnd+")");
	                }else {
	                    eval("transition_"+plugin.settings.effect+"("+offsetStart+", "+offsetEnd+")");
	                }
	                
	                plugin.nav.find('.current').removeClass('current');
	                plugin.nav.find('a.page:eq('+(page - 1)+')').addClass('current');
	                
	                switch(plugin.settings.currentPage) {
	                    case 1:
	                        $('.easyPaginateNav a', plugin).removeClass('disabled');
	                        $('.easyPaginateNav a.first, .easyPaginateNav a.prev', plugin).addClass('disabled');
	                        break;
	                    case plugin.settings.pages:
	                        $('.easyPaginateNav a', plugin).removeClass('disabled');
	                        $('.easyPaginateNav a.last, .easyPaginateNav a.next', plugin).addClass('disabled');
	                        break;
	                    default:
	                        $('.easyPaginateNav a', plugin).removeClass('disabled');
	                        break;
	                }
	            }
	        };
	        
	        var transition_default = function(offsetStart, offsetEnd) {
	            plugin.currentElements.hide();
	            plugin.currentElements = plugin.settings.objElements.slice(offsetStart, offsetEnd).clone();
	            plugin.el.html(plugin.currentElements);
	            plugin.currentElements.show();
	        };
	        
	        var transition_fade = function(offsetStart, offsetEnd) {
	            plugin.currentElements.fadeOut();
	            plugin.currentElements = plugin.settings.objElements.slice(offsetStart, offsetEnd).clone();
	            plugin.el.html(plugin.currentElements);
	            plugin.currentElements.fadeIn();
	        };
	        
	        var transition_slide = function(offsetStart, offsetEnd) {
	            plugin.currentElements.animate({
	                'margin-left': plugin.settings.slideOffset * -1,
	                'opacity': 0
	            }, function() {
	                $(this).remove();
	            });
	            
	            plugin.currentElements = plugin.settings.objElements.slice(offsetStart, offsetEnd).clone();
	            plugin.currentElements.css({
	                'margin-left': plugin.settings.slideOffset,
	                'display': 'block',
	                'opacity': 0,
	                'min-width': plugin.el.width() / 2
	            });
	            plugin.el.html(plugin.currentElements);
	            plugin.currentElements.animate({
	                'margin-left': 0,
	                'opacity': 1
	            });
	        };
	                
	        var transition_climb = function(offsetStart, offsetEnd) {            
	            plugin.currentElements.each(function(i) {
	                var $objThis = $(this);
	                setTimeout(function() {
	                    $objThis.animate({
	                        'margin-left': plugin.settings.slideOffset * -1,
	                        'opacity': 0
	                    }, function() {
	                        $(this).remove();
	                    });
	                }, i * 200);
	            });
	            
	            plugin.currentElements = plugin.settings.objElements.slice(offsetStart, offsetEnd).clone();
	            plugin.currentElements.css({
	                'margin-left': plugin.settings.slideOffset,
	                'display': 'block',
	                'opacity': 0,
	                'min-width': plugin.el.width() / 2
	            });
	            plugin.el.html(plugin.currentElements);
	            plugin.currentElements.each(function(i) {
	                var $objThis = $(this);
	                setTimeout(function() {
	                    $objThis.animate({
	                        'margin-left': 0,
	                        'opacity': 1
	                    });
	                }, i * 200);
	            });
	        };
	                
	        plugin.settings = $.extend({}, defaults, options);
	        
	        plugin.currentElements = $([]);
	        plugin.settings.objElements = plugin.el.find(plugin.settings.paginateElement);
	        plugin.settings.pages = getNbOfPages();
	        if(plugin.settings.pages > 1) {
	            plugin.el.html();
	    
	            // Here we go
	            displayNav();
	            
	            page = 1;
	            if(document.location.hash.indexOf('#'+plugin.settings.hashPage+':') != -1) {
	                page = parseInt(document.location.hash.replace('#'+plugin.settings.hashPage+':', ''));
	                if(page.length <= 0 || page < 1 || page > plugin.settings.pages) {
	                    page = 1;
	                }
	            }
	            
	            displayPage(page, 'default');
	        }
	    });
	};
	})(jQuery);

//Pagination Noticias y Promociones

(function($){
	$.fn.easyPaginateNoticias = function (options) {
	    var defaults = {
	        paginateElement: 'div',
	        hashPage: 'page',
	        elementsPerPage: 4,
	        effect: 'default',
	        slideOffset: 200,        
	        prevButton: true,
	        prevButtonText: '<',        
	        nextButton: true,
	        nextButtonText: '>',        
	        onSomeEvent: function() {}
	    }
	        
	    return this.each (function (instance) {        
	        
	        var plugin = Object;
	        plugin.el = $(this);
	        plugin.el.addClass('easyPaginateList');
	        plugin.el.addClass('span12');

	        plugin.settings = {
	            pages: 0,
	            objElements: Object,
	            currentPage: 1
	        }
	        
	        var getNbOfPages = function() {
	            return Math.ceil(plugin.settings.objElements.length / plugin.settings.elementsPerPage);         
	        };
	        
	        var displayNav = function() {
	            htmlNav = '<div class="easyPaginateNav">';
	            
	            if(plugin.settings.firstButton) {
	                htmlNav += '<a href="#'+plugin.settings.hashPage+':1" title="First page" rel="1" class="first">'+plugin.settings.firstButtonText+'</a>';
	            }
	            
	            if(plugin.settings.prevButton) {
	                htmlNav += '<a href="" title="Previous" rel="" class="prev">'+plugin.settings.prevButtonText+'</a>';
	            }
	            
	            
	            if(plugin.settings.nextButton) {
	                htmlNav += '<a href="" title="Next" rel="" class="next">'+plugin.settings.nextButtonText+'</a>';
	            }
	            
	            if(plugin.settings.lastButton) {
	                htmlNav += '<a href="#'+plugin.settings.hashPage+':'+plugin.settings.pages+'" title="Last page" rel="'+plugin.settings.pages+'" class="last">'+plugin.settings.lastButtonText+'</a>';
	            }
	            
	            htmlNav += '</div>';
	            plugin.nav = $(htmlNav);
	            
	            plugin.el.after(plugin.nav);
	            
	            $('.easyPaginateNav a.page, .easyPaginateNav a.first, .easyPaginateNav a.last', plugin).live('click', function(e) {                
	                e.preventDefault();
	                displayPage($(this).attr('rel'));                
	            });
	            
	            $('.easyPaginateNav a.prev', plugin).live('click', function(e) {                
	                e.preventDefault();
	                page = plugin.settings.currentPage > 1?parseInt(plugin.settings.currentPage) - 1:1;
	                displayPage(page);
	            });
	            
	            $('.easyPaginateNav a.next', plugin).live('click', function(e) {                
	                e.preventDefault();
	                page = plugin.settings.currentPage < plugin.settings.pages?parseInt(plugin.settings.currentPage) + 1:plugin.settings.pages;
	                displayPage(page);
	            });
	        };
	        
	        var displayPage = function(page, forceEffect) {
	            if(plugin.settings.currentPage != page) {
	                plugin.settings.currentPage = parseInt(page);
	                offsetStart = (page - 1) * plugin.settings.elementsPerPage;
	                offsetEnd = page * plugin.settings.elementsPerPage;
	                if(typeof(forceEffect) != 'undefined') {
	                    eval("transition_"+forceEffect+"("+offsetStart+", "+offsetEnd+")");
	                }else {
	                    eval("transition_"+plugin.settings.effect+"("+offsetStart+", "+offsetEnd+")");
	                }
	                
	                plugin.nav.find('.current').removeClass('current');
	                plugin.nav.find('a.page:eq('+(page - 1)+')').addClass('current');
	                
	                switch(plugin.settings.currentPage) {
	                    case 1:
	                        $('.easyPaginateNav a', plugin).removeClass('disabled');
	                        $('.easyPaginateNav a.first, .easyPaginateNav a.prev', plugin).addClass('disabled');
	                        break;
	                    case plugin.settings.pages:
	                        $('.easyPaginateNav a', plugin).removeClass('disabled');
	                        $('.easyPaginateNav a.last, .easyPaginateNav a.next', plugin).addClass('disabled');
	                        break;
	                    default:
	                        $('.easyPaginateNav a', plugin).removeClass('disabled');
	                        break;
	                }
	            }
	        };
	        
	        var transition_default = function(offsetStart, offsetEnd) {
	            plugin.currentElements.hide();
	            plugin.currentElements = plugin.settings.objElements.slice(offsetStart, offsetEnd).clone();
	            plugin.el.html(plugin.currentElements);
	            plugin.currentElements.show();
	        };
	        
	        var transition_fade = function(offsetStart, offsetEnd) {
	            plugin.currentElements.fadeOut();
	            plugin.currentElements = plugin.settings.objElements.slice(offsetStart, offsetEnd).clone();
	            plugin.el.html(plugin.currentElements);
	            plugin.currentElements.fadeIn();
	        };
	        
	        var transition_slide = function(offsetStart, offsetEnd) {
	            plugin.currentElements.animate({
	                'margin-left': plugin.settings.slideOffset * -1,
	                'opacity': 0
	            }, function() {
	                $(this).remove();
	            });
	            
	            plugin.currentElements = plugin.settings.objElements.slice(offsetStart, offsetEnd).clone();
	            plugin.currentElements.css({
	                'margin-left': plugin.settings.slideOffset,
	                'display': 'block',
	                'opacity': 0,
	                'min-width': plugin.el.width() / 2
	            });
	            plugin.el.html(plugin.currentElements);
	            plugin.currentElements.animate({
	                'margin-left': 0,
	                'opacity': 1
	            });
	        };
	                
	        var transition_climb = function(offsetStart, offsetEnd) {            
	            plugin.currentElements.each(function(i) {
	                var $objThis = $(this);
	                setTimeout(function() {
	                    $objThis.animate({
	                        'margin-left': plugin.settings.slideOffset * -1,
	                        'opacity': 0
	                    }, function() {
	                        $(this).remove();
	                    });
	                }, i * 200);
	            });
	            
	            plugin.currentElements = plugin.settings.objElements.slice(offsetStart, offsetEnd).clone();
	            plugin.currentElements.css({
	                'margin-left': plugin.settings.slideOffset,
	                'display': 'block',
	                'opacity': 0,
	                'min-width': plugin.el.width() / 2
	            });
	            plugin.el.html(plugin.currentElements);
	            plugin.currentElements.each(function(i) {
	                var $objThis = $(this);
	                setTimeout(function() {
	                    $objThis.animate({
	                        'margin-left': 0,
	                        'opacity': 1
	                    });
	                }, i * 200);
	            });
	        };
	                
	        plugin.settings = $.extend({}, defaults, options);
	        
	        plugin.currentElements = $([]);
	        plugin.settings.objElements = plugin.el.find(plugin.settings.paginateElement);
	        plugin.settings.pages = getNbOfPages();
	        if(plugin.settings.pages > 1) {
	            plugin.el.html();
	    
	            // Here we go
	            displayNav();
	            
	            page = 1;
	            if(document.location.hash.indexOf('#'+plugin.settings.hashPage+':') != -1) {
	                page = parseInt(document.location.hash.replace('#'+plugin.settings.hashPage+':', ''));
	                if(page.length <= 0 || page < 1 || page > plugin.settings.pages) {
	                    page = 1;
	                }
	            }
	            
	            displayPage(page, 'default');
	        }
	    });
	};
	})(jQuery);


