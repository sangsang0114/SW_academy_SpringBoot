package org.yoon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemService {
    @Autowired
    MemMapper memMapper;

    Mem login(Mem mem) {

        Mem LoginMem = memMapper.findById(mem.getMem_id());
        if (LoginMem.getMem_pw().equals(mem.getMem_pw()))
            return LoginMem;

        else return null;
    }
}