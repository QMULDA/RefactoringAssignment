    package org.vsapry.Controller;

    import org.vsapry.Model.MintermList;

    import java.util.Set;

    public class MintermListController {

        private MintermList mintermList;

        public MintermListController(MintermList mintermList) {
            this.mintermList = mintermList;
        }

        public Set<String> getMintermList(){
            return mintermList.getMintermList();
        }

        public void setMintermList(String userStringInputForMintermValue){
            mintermList.setMintermList(userStringInputForMintermValue);
        }



    }
