note
    description: "API tests for CATEGORY_API"
    date: "$Date$"
    revision: "$Revision$"


class CATEGORY_API_TEST

inherit

    EQA_TEST_SET

feature -- Test routines

    
    test_category
            -- Returns Amazon category information from Keepa API.
            -- 
            -- Retrieve category objects using their node ids and (optional) their parent tree. 
        local
            l_response: LIST [CATEGORY]
            l_key: STRING_32
            l_domain: INTEGER_32
            l_category: INTEGER_32
            l_parents: INTEGER_32
        do
            -- TODO: Initialize required params.
            -- l_key
            -- l_domain
            -- l_category
            -- l_parents
                      
            -- l_response := api.category(l_key, l_domain, l_category, l_parents)
            assert ("not_implemented", False)
        end

feature {NONE} -- Implementation

    api: CATEGORY_API
            -- Create an object instance of `CATEGORY_API'.
        once            
            create { CATEGORY_API } Result
        end

end
