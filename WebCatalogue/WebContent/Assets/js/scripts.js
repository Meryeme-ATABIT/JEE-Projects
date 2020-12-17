function addToPanier(id) {
    $.ajax({
        url: '/Panier',
        method: 'POST',
        data: {add: id},
        success: function() {
     
        },
        error: function() {
        
       
        }
    });
}
