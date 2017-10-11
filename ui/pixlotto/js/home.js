$( document ).ready( function() {
    jQuery( 'ul.nav li.dropdown' ).hover( function() {
        jQuery( this ).find( '.dropdown-menu' ).stop( true, true ).delay( 200 ).fadeIn();
    }, function() {
        jQuery( this ).find( '.dropdown-menu' ).stop( true, true ).delay( 200 ).fadeOut();
    });	

    if ( getCookie( 'lang' ) == '' ) {
		setCookie( 'lang', 'de', 1 );
	}
	
    getHomeFields( getCookie( 'lang' ) );
    prepareSelects();

    var preview = $(".upload-preview img");

	$("#image-upload").change(function(event){
	     $(".luckyNumbers").html( "" );
	  	 var input = $(event.currentTarget);
	     var file = input[0].files[0];
	     var reader = new FileReader();
	     reader.onload = function(e){
	         image_base64 = e.target.result;
	         preview.attr("src", image_base64);
	     };
	     reader.readAsDataURL(file);
	});

	$('#main_button').click(function () {
        var btn = $(this);
        btn.button('loading');
    	
    	$('#luckyform').ajaxForm({
	        url : api.host + 'image',
    		dataType : 'json',
//	        success : function (response) {
    		statusCode: {
    		    200: function( response ) {
	        		var numbers = response.luckyNumbers;
	        		
					$("#info").hide(500);
					$("#divHeaderLine1").hide(500);
					$("#lottoPartner").hide(500);

	        		if ( response.super != "" ) numbers += ' Super: ' + response.super;
					$("#luckyNumbers").html( numbers );
					$("#divHeaderLine1").show(500);
					$("#lottoPartner").show(1000);

					btn.button('reset');
    		    }
	        }
	    });
    });		
});


function getHomeFields( lang ) {
	setCookie( 'lang', lang, 1 );
	
    api.homeFields( lang, function( data ) {
    	$.each( data, function( key, val ) {
    		$( '#' + val.key ).html( val.value );
    	});
	});

    showPageIn( 'home', getCookie( 'lang' ) );
}


function prepareSelects() {
    api.selectConf( function( data ) {
    	$( '#lottoland' ).html( '' );
    	$( '#lottotype' ).html( '' );
    	
    	var currCountry = '' 
		
    	$.each( data, function( key, val ) {
			var split = val.split( '_' );
			if ( currCountry != split[0] ) {
				currCountry = split[0];
				$( '#lottoland' ).append( '<option value="' + split[0] + '">' + split[0] + '</option>' );
			}
			
			$( '#lottotype' ).append( '<option value="' + split[1] + '" class="' + split[0] + '">' + split[1] + '</option>' );
		});
    	
        
    	$("#lottotype").chained("#lottoland");
	});
}
