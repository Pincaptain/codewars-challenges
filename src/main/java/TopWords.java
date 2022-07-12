import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopWords {

    public static List<String> top3(String s) {
        Map<String, Long> wordCountMap = Arrays.stream(s.trim().split("[\s$&+,:;=?@#|/<>.^*()_%!-]+"))
                .filter(word -> !word.equals(""))
                .filter(word -> word.chars()
                        .mapToObj(c -> (char) c)
                        .anyMatch(Character::isAlphabetic))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()));

        System.out.println(wordCountMap);

        return wordCountMap.keySet()
                .stream()
                .sorted(Comparator.comparing(wordCountMap::get).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(top3("hTRjaI obCPeJ'K!EmcWteTQUs_EmcWteTQUs aQw pFSvy-MRWr MRWr EmcWteTQUs_aQw?dmkfiPgLm DuORmPet'L:pFSvy MRWr?aQw dmkfiPgLm ugnMg nLxVqJpDT MRWr!obCPeJ'K pFSvy;aQw QziXe aQw;obCPeJ'K sKTFa dmkfiPgLm sKTFa.EmcWteTQUs VnwKbJIYpH,egmxSxLyV;egmxSxLyV jUbqrwEwD-obCPeJ'K EmcWteTQUs pFSvy MRWr.EmcWteTQUs nLxVqJpDT?egmxSxLyV MRWr_MRWr,DuORmPet'L egmxSxLyV/YjckZfbSqW:sKTFa egmxSxLyV.dmkfiPgLm_sKTFa pFSvy_QziXe_egmxSxLyV sKTFa,VnwKbJIYpH sKTFa_obCPeJ'K/egmxSxLyV-VnwKbJIYpH!MRWr dmkfiPgLm_dmkfiPgLm:aQw.ugnMg VnwKbJIYpH EmcWteTQUs obCPeJ'K DuORmPet'L-DuORmPet'L-DuORmPet'L-obCPeJ'K VnwKbJIYpH nLxVqJpDT,egmxSxLyV_sKTFa-EmcWteTQUs VnwKbJIYpH pFSvy/dmkfiPgLm aQw jUbqrwEwD aQw:jUbqrwEwD ugnMg MRWr/dmkfiPgLm,pFSvy MRWr_egmxSxLyV VnwKbJIYpH MRWr,EmcWteTQUs:VnwKbJIYpH-DuORmPet'L aQw/egmxSxLyV?pFSvy VnwKbJIYpH sKTFa QziXe:nLxVqJpDT dmkfiPgLm dmkfiPgLm hTRjaI crBFn?dmkfiPgLm sKTFa sKTFa MRWr:VnwKbJIYpH pFSvy,hVfI crBFn obCPeJ'K;nLxVqJpDT sKTFa:dmkfiPgLm MRWr VnwKbJIYpH aQw QziXe aQw dmkfiPgLm MRWr:nLxVqJpDT YjckZfbSqW:egmxSxLyV MRWr_pFSvy VnwKbJIYpH.EmcWteTQUs.egmxSxLyV MRWr?sKTFa;aQw,dmkfiPgLm!jUbqrwEwD dmkfiPgLm_LqWoVeE,VnwKbJIYpH,sKTFa;ugnMg-aQw VnwKbJIYpH?obCPeJ'K,egmxSxLyV:ugnMg QziXe/pFSvy nLxVqJpDT ugnMg!sKTFa/DuORmPet'L/jUbqrwEwD EmcWteTQUs pFSvy LqWoVeE obCPeJ'K crBFn!aQw dmkfiPgLm:MRWr jUbqrwEwD;DuORmPet'L.sKTFa dmkfiPgLm?QziXe sKTFa VnwKbJIYpH sKTFa egmxSxLyV ugnMg-EmcWteTQUs aQw pFSvy MRWr,hTRjaI aQw egmxSxLyV pFSvy,sKTFa QziXe_egmxSxLyV.obCPeJ'K pFSvy MRWr:MRWr;aQw nLxVqJpDT:YjckZfbSqW egmxSxLyV LqWoVeE obCPeJ'K obCPeJ'K obCPeJ'K!sKTFa.pFSvy.pFSvy pFSvy nLxVqJpDT egmxSxLyV/egmxSxLyV,sKTFa_hTRjaI dmkfiPgLm MRWr hVfI YjckZfbSqW hTRjaI sKTFa,LqWoVeE/DuORmPet'L;jUbqrwEwD obCPeJ'K!hTRjaI-ugnMg/VnwKbJIYpH?aQw pFSvy VnwKbJIYpH crBFn jUbqrwEwD-aQw sKTFa/dmkfiPgLm aQw egmxSxLyV!nLxVqJpDT aQw.egmxSxLyV egmxSxLyV DuORmPet'L QziXe EmcWteTQUs QziXe aQw DuORmPet'L EmcWteTQUs VnwKbJIYpH?egmxSxLyV;nLxVqJpDT pFSvy VnwKbJIYpH!sKTFa nLxVqJpDT sKTFa egmxSxLyV crBFn.MRWr LqWoVeE pFSvy MRWr:VnwKbJIYpH-nLxVqJpDT-QziXe egmxSxLyV!egmxSxLyV!pFSvy aQw YjckZfbSqW.YjckZfbSqW ugnMg;obCPeJ'K hTRjaI;pFSvy VnwKbJIYpH nLxVqJpDT?dmkfiPgLm!QziXe,YjckZfbSqW MRWr,jUbqrwEwD egmxSxLyV egmxSxLyV MRWr_dmkfiPgLm DuORmPet'L egmxSxLyV VnwKbJIYpH/sKTFa aQw!EmcWteTQUs egmxSxLyV aQw pFSvy hTRjaI ugnMg aQw/jUbqrwEwD;EmcWteTQUs DuORmPet'L ugnMg YjckZfbSqW aQw MRWr,sKTFa,aQw!MRWr_QziXe!hTRjaI ugnMg_MRWr:EmcWteTQUs aQw dmkfiPgLm/jUbqrwEwD!EmcWteTQUs DuORmPet'L/"));
    }
}
