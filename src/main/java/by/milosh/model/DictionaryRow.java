package by.milosh.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class DictionaryRow {

    private String word;
    private Integer id;

    public static Comparator<DictionaryRow> compareByWord() {
        return new Comparator<DictionaryRow>() {
            @Override
            public int compare(DictionaryRow dr1, DictionaryRow dr2) {
                return dr1.getWord().compareTo(dr2.getWord());
            }
        };
    }
}
