package com.xy.springboot3.service;

import com.robert.vesta.service.bean.Id;
import com.robert.vesta.service.intf.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @fileName:UidService
 * @author:xy
 * @date:2018/12/8
 * @description:
 */
@Service
public class UidService {

    @Resource
    private IdService idService;

    public long genId() {
    System.out.println(idService.getClass());
        return idService.genId();
    }

    public Id explainId(long id ) {
        return idService.expId(id);
    }

    public long makeId( long version, long type, long genMethod, long machine, long time, long seq ) {

        long madeId = -1;
        if (time == -1 || seq == -1)
            throw new IllegalArgumentException( "Both time and seq are required." );
        else if (version == -1) {
            if (type == -1) {
                if (genMethod == -1) {
                    if (machine == -1) {
                        madeId = idService.makeId(time, seq);
                    } else {
                        madeId = idService.makeId(machine, time, seq);
                    }
                } else {
                    madeId = idService.makeId(genMethod, machine, time, seq);
                }
            } else {
                madeId = idService.makeId(type, genMethod, machine, time, seq);
            }
        } else {
            madeId = idService.makeId(version, type, genMethod, time,
                    seq, machine);
        }

        return madeId;
    }

}
