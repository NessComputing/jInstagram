/**
 * Copyright (C) 2011 by Sachin Handiekar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jinstagram.auth.model;

import java.io.Serializable;

/**
 * Represents an OAuth token (either request or access token) and its secret
 */
public class Token implements Serializable {
    private static final long serialVersionUID = 715000866082812683L;

    private final String rawResponse;

    private final String secret;

    private final String token;

    /**
     * Default constructor
     * 
     * @param token token value
     * @param secret token secret
     */
    public Token(String token, String secret) {
        this(token, secret, null);
    }

    public Token(String token, String secret, String rawResponse) {
        this.token = token;
        this.secret = secret;
        this.rawResponse = rawResponse;
    }

    public String getToken() {
        return token;
    }

    public String getSecret() {
        return secret;
    }

    public String getRawResponse() {
        if (rawResponse == null) {
            throw new IllegalStateException(
                    "This token object was not constructed by scribe and does not have a rawResponse");
        }

        return rawResponse;
    }

    @Override
    public String toString() {
        return String.format("Token[%s , %s]", token, secret);
    }
}
