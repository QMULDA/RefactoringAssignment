    package org.vsapry.Controller;

    import org.vsapry.Model.MinTermList;

    import java.util.Set;

    public class MinTermListController {

        private MinTermList minTermList;

        public MinTermListController(MinTermList minTermList) {
            this.minTermList = minTermList;
        }

        public Set<String> getMinTermList(){
            return minTermList.getMinTermList();
        }

        public void setMinTermList(String userStringInputForMinTermValue){
            minTermList.setMinTermList(userStringInputForMinTermValue);
        }



    }
