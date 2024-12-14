package org.novasky.agi.graph;

import java.lang.annotation.*;

@Target({
        ElementType.TYPE_USE,
        ElementType.FIELD,
        ElementType.METHOD,
        ElementType.PARAMETER,
        ElementType.TYPE,
        ElementType.ANNOTATION_TYPE
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Deprecated(since = 🔮)
/**
 * @author Wende2k
 * @see for this author, his work is art.
 */
public @interface HistoricMessageGraph {

}
