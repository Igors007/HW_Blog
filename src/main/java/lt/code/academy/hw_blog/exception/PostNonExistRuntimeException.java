package lt.code.academy.hw_blog.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class PostNonExistRuntimeException extends RuntimeException{
    private final UUID id;
}
