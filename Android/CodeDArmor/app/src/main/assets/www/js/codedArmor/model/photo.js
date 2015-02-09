/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function($)
        {
            
            var Photo = Backbone.Model.extend
            (
                {
                    defaults :
                    {
                        url: "",
                        prenom: ""
                    }
                }
            );
            /* ContactCollection [ new Contact(), new Contact() ]  */
            var ContactsCollection = Backbone.Collection.extend
            (
               {
                    model : ContactModel
               }
            );

        })(jQuery);
