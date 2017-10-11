var api = {
	host: 'http://localhost:5959/app/api/', 
    page: function( page, lang, callback ) {
        $.ajax( api.host + 'page/' + page + '/' + lang, {
            type: 'GET',
            dataType: 'json',
            success: callback
        });
    },
    selectConf: function( callback ) {
        $.ajax( api.host + 'options/lotto', {
            type: 'GET',
            dataType: 'json',
            success: callback
        });
    },
    homeFields: function( lang, callback ) {
        $.ajax( api.host + 'home/main/' + lang, {
            type: 'GET',
            dataType: 'json',
            success: callback
        });
    },
}


function showPageIn( page, lang ) {
	setCookie( 'lang', lang, 1 );
	
    api.page( page, lang, function( data ) {
		$( '#divTagLine' ).html( data.header.slogan );
		$( '#menu0' ).html( data.header.menu0 );
		$( '#menu1' ).html( data.header.menu1 );
		$( '#menu2' ).html( data.header.menu2 );
		$( '#menu2_1' ).html( data.header.menu2_1 );
		$( '#title' ).html( data.title );
		$( '#text' ).html( data.text );
		$( '#copyright' ).html( data.footer.copyright );
		$( '#feedback' ).html( data.footer.feedback );
	});
}


function setCookie( cname, cvalue, exdays ) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}


function getCookie( cname ) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for ( var i = 0; i < ca.length; i++ ) {
        var c = ca[i];
        while ( c.charAt( 0 ) == ' ' ) c = c.substring( 1 );
        if ( c.indexOf( name ) == 0 ) return c.substring( name.length, c.length );
    }
    return "";
}

