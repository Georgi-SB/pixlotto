function showPageIn( name, lang ) {
	$.getJSON( "http://localhost:8080/app/api/page/" + name + "/" + lang, function( data ) {
		// Header
		$('#divTagLine').html( data.header.slogan );
		$('#menu0').html( data.header.menu0 );
		$('#menu1').html( data.header.menu1  );
		$('#menu2').html( data.header.menu2  );
		$('#menu2_1').html( data.header.menu2_1  );
		
		// Content
		$('#title').html( data.title );
		$('#text').html( data.text );
		
		// Footer
		$('#copyright').html( data.footer.copyright );
		$('#feedback').html( data.footer.feedback );		
	});
}
