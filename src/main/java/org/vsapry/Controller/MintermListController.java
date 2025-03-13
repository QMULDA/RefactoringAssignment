    package org.vsapry.Controller;

    import org.vsapry.Model.MintermList;

    import java.util.Set;

    public class MintermListController {

        private MintermList minTermList;

        public MintermListController(MintermList minTermList) {
            this.minTermList = minTermList;
        }

        public Set<String> getMintermList(){
            return minTermList.getMintermList();
        }

        public void setMintermList(String userStringInputForMintermValue){
            minTermList.setMintermList(userStringInputForMintermValue);
        }



    }
