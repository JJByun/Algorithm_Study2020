class Main{
    public static void main(String args[]){
        int sumNum;
        int sumHex;
        int sumTwel;
        String twel = "0123456789ab"; //12진수 변환을 위해 미리 설정
        for(int i=2992; i<=9999; i++){ 
            int tmp = i;
            sumNum=0; sumHex=0; sumTwel=0;
            //10진수부터 계산
            while(tmp != 0){
                sumNum += tmp%10;
                tmp /= 10;
            }
            //16진수 계산
            String strHex = Integer.toHexString(i);
            for(int j=0; j<strHex.length();j++){
                char c = strHex.charAt(j);
                //System.out.println("C " + c);
                if( '0' <= c && c <= '9'){
                    sumHex += c - '0'; //char형에 '0'을 빼주면 바로 Char to Int Conversion 가능
                }else{
                    if(c=='a')
                        sumHex += 10;
                    else if(c=='b')
                        sumHex += 11;
                    else if(c=='c')
                        sumHex += 12;
                    else if(c=='d')
                        sumHex += 13;
                    else if(c=='e')
                        sumHex += 14;
                    else if(c=='f')
                        sumHex += 15;
                }
            }
            //12진수 계산
            tmp = i;
            String strTwelv="";
            while(tmp != 0){
                int rest = tmp % 12;
                strTwelv += twel.charAt(rest); //해당 자리수 값을 charAt를 이용하여 찾아주기
                tmp /= 12;
            }
            for(int j=0; j<strTwelv.length(); j++) {
                char c = strTwelv.charAt(j);
                if ('0' <= c && c <= '9') {
                    sumTwel += c - '0';
                } else {
                    if (c == 'a')
                        sumTwel += 10;
                    else if (c == 'b')
                        sumTwel += 11;
                }
            }
            if(sumNum == sumHex && sumNum == sumTwel) //세개가 다 같다면 출력
                System.out.println(i);
        }

    }
}