package pl.mateuszgorski.whatsnew;

import java.util.Arrays;

public class IntroducedInJava8 {

  //Optional class, method below returns 0 if gets null, Baeldung tutorials
  void optionalMethod() {
    int min1 = Arrays.stream(new int[]{1, 2, 3, 4, 5})
        .min()
        .orElse(0);
  }

  //Streams, lambdas, functional interfaces - method below gets tracks longer than 60 from fictional Album class,
  // gets their names and puts them to Set- Java 8 Lambdas O'Reilly
//    public Set<String> findLongTracks(List<Album> albums) {
//        return albums.stream()
//                .flatMap(album -> album.getTracks())
//                .filter(track -> track.getLength() > 60)
//                .map(track -> track.getName())
//                .collect(toSet());
}
