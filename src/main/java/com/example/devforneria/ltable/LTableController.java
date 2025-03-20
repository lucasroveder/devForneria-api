package com.example.devforneria.ltable;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ltable")
public class LTableController {

    @Autowired
    private LTableService lTableService;

    @GetMapping
    public List<LTable> findAll(){
        return lTableService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LTable> findById(@PathVariable("id") Long id){
        return lTableService.findById(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public LTable createLTable(@RequestBody LTable lTable){
        return lTableService.save(lTable);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LTable> updateLTable(@PathVariable("id") Long id, @RequestBody LTable lTable){
        try{
            LTable lTable1 = lTableService.updateLTable(id, lTable);
            return ResponseEntity.ok(lTable1);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLTable(@PathVariable("id") Long id){
        lTableService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
