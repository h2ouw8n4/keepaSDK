note
    description: "API tests for PRODUCT_API"
    date: "$Date$"
    revision: "$Revision$"


class PRODUCT_API_TEST

inherit

    EQA_TEST_SET

feature -- Test routines

    
    test_product
            -- Retrieve the product for the specified ASIN and domain.
            -- 
            -- Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks. 
        local
            l_response: LIST [CATEGORY]
            l_key: STRING_32
            l_domain: INTEGER_32
            l_asin: STRING_32
            l_code: STRING_32
        do
            -- TODO: Initialize required params.
            -- l_key
            -- l_domain
                      
            -- l_response := api.product(l_key, l_domain, l_asin, l_code)
            assert ("not_implemented", False)
        end

feature {NONE} -- Implementation

    api: PRODUCT_API
            -- Create an object instance of `PRODUCT_API'.
        once            
            create { PRODUCT_API } Result
        end

end
