    package org.vsapry.Controller;

    import org.vsapry.Model.MinTermList;

    import java.util.Set;

    public class MinTermListController {

        private MinTermList minTermList;

        public MinTermListController(MinTermList minTermList) {
            this.minTermList = minTermList;
        }

        public Set<String> getMin(){
            return minTermList.getMin();
        }

        public void setMinList(String x){
            minTermList.setMinList(x);
        }



    }
