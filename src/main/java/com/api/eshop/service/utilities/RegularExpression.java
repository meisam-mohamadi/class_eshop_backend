package com.api.eshop.service.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: meisam Mohamadi
 * Date: 12/16/12
 * Time: 10:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegularExpression {
    private Pattern pattern;
    private Matcher matcher;

    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
    /*
    ^                     # Start of the line
    [a-z0-9_-]	          # Match characters and symbols in the list, a-z, 0-9, underscore, hyphen
    {3,15}                # Length at least 3 characters and maximum length of 15
    $                     # End of the line
    */
    private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    /*
        (		    	    # Start of group
        (?=.*\d)		    #   must contains one digit from 0-9
        (?=.*[a-z])	    	#   must contains one lowercase characters
        (?=.*[A-Z])	    	#   must contains one uppercase characters
        (?=.*[@#$%])		#   must contains one special symbols in the list "@#$%"
        .		            #     match anything with previous condition checking
        {6,20}	            #        length at least 6 characters and maximum of 20
        )		        	# End of group
     */


    private static final String IPADDRESS_PATTERN =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    /*
        ^		        #start of the line
        (	        	#  start of group #1
        [01]?\\d\\d?    #    Can be one or two digits. If three digits appear, it must start either 0 or 1
                        #    e.g ([0-9], [0-9][0-9],[0-1][0-9][0-9])
        |		        #    ...or
        2[0-4]\\d	    #    start with 2, follow by 0-4 and end with any digit (2[0-4][0-9])
        |               #    ...or
        25[0-5]         #    start with 2, follow by 5 and ends with 0-5 (25[0-5])
        )		        #  end of group #2
        \.              #  follow by a dot "."
        ....            # repeat with 3 times (3x)
        $		        #end of the line
     */
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    /*
        ^		        	#start of the line
        [_A-Za-z0-9-\\+]+	#  must start with string in the bracket [ ], must contains one or more (+)
        (			        #   start of group #1
        \\.[_A-Za-z0-9-]+	#     follow by a dot "." and string in the bracket [ ], must contains one or more (+)
        )*		        	#   end of group #1, this group is optional (*)
        @		        	#     must contains a "@" symbol
        [A-Za-z0-9-]+       #       follow by string in the bracket [ ], must contains one or more (+)
        (		        	#         start of group #2 - first level TLD checking
        \\.[A-Za-z0-9]+     #           follow by a dot "." and string in the bracket [ ], must contains one or more (+)
        )*		            #         end of group #2, this group is optional (*)
        (			        #         start of group #3 - second level TLD checking
        \\.[A-Za-z]{2,}     #           follow by a dot "." and string in the bracket [ ], with minimum length of 2
        )			        #         end of group #3
        $			        #end of the line
     */


    public boolean validateEmail( String email) {

        pattern = Pattern.compile(EMAIL_PATTERN); // moshakhas mikonim ke  az che pattrni mikhahim estefadeh konim
        matcher = pattern.matcher(email);  // natijeie moghaiese dar yek matcher gharar migirad
        return matcher.matches(); // dar soorate validate boodan true va dar gheire insoorat false bar migardad

    }
    public boolean validatePassword( String password) {

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();

    }



}
