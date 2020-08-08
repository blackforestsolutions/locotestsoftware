package de.blackforestsolutions.locotestsoftware.testutil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class TestUtils {

    /**
     * Reads given resource file as a string.
     *
     * @param fileName the path to the resource file
     * @return the file's contents or null if the file could not be opened
     */
    public static String getResourceFileAsString(String fileName) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, UTF_8));
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
        return null;
    }

    public static <T> T retrieveJsonPojoFromResponse(ResponseEntity<String> response, Class<T> pojo) throws JsonProcessingException {
        Objects.requireNonNull(response.getBody(), "response body is not allowed to be null");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.getBody(), pojo);
    }

    public static <T> List<T> retrieveListJsonPojoFromResponse(ResponseEntity<String> response, Class<T> pojo) throws JsonProcessingException {
        Objects.requireNonNull(response.getBody(), "response body is not allowed to be null");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.getBody(), mapper.getTypeFactory().constructCollectionType(List.class, pojo));
    }

    public static <T> T retrieveXmlPojoFromResponse(ResponseEntity<String> response, Class<T> pojo) throws JAXBException {
        Objects.requireNonNull(response.getBody(), "response body is not allowed to be null");
        StringReader readerResultBody = new StringReader(response.getBody());
        JAXBContext jaxbContext = JAXBContext.newInstance(pojo);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        //noinspection unchecked
        return (T) unmarshaller.unmarshal(readerResultBody);
    }

}
