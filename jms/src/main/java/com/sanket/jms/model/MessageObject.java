package com.sanket.jms.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public record MessageObject(@JsonPropertyDescription String content,
                            @JsonPropertyDescription String recipient,
                            @JsonPropertyDescription long intervalMillis) {
}
