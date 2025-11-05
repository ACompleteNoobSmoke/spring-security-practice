package com.acompletenoobsmoke.springsecurity.exceptions;

import java.time.ZonedDateTime;
import java.util.List;

public record APIError(String path, String message, int statusCode, ZonedDateTime zonedDateTime, List<String> errors) {
}
