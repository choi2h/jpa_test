package ffs.controller;

import ffs.domain.Member;
import ffs.dto.response.member.SearchMemberResponse;
import ffs.service.SearchMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SearchMemberController {

    private final SearchMemberService searchMemberService;

    @GetMapping("/members")
    public ResponseEntity<Object> getAllMembers() {
        List<Member> memberList = searchMemberService.getAllMemberList();

        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }

    @GetMapping("/member")
    public ResponseEntity<Object> getMemberFromNameAndLastPhoneNumber(@RequestParam String name, @RequestParam String lastPhoneNumber) {
        SearchMemberResponse response = searchMemberService.getMemberFromNameAndLastPhoneNumber(name, lastPhoneNumber);

        if(response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
