package easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RansomNoteTest {

  private final RansomNote solution = new RansomNote();

  @DisplayName("Given ransom note and magazine, then should respond weather note can be "
      + "constructed from magazine")
  @ParameterizedTest(name = "{index}. can construct: {2} note={0} magazine={1}")
  @CsvSource({
      "a,b,false",
      "aa,ab,false",
      "aa,aab,true",
      "i got your dog,i got your dog,true",
      "i got your dog,abcdefgghijklmnooopqrstuvwxyz,true",
      "keep coding,coding is the activity for,false"
  })
  void canConstruct(String ransomNote, String magazine, boolean expected) {
    assertEquals(expected,
        solution.canConstruct(ransomNote.replaceAll("\s", ""),
            magazine.replaceAll("\s", "")));
  }
}