package com.covoid21.panman.database.controller;

import com.covoid21.panman.entity.user.User;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *
 * @param <T>
 */
@RestController
@ResponseBody
@RequestMapping
public abstract class UserControllerBase<T extends User> extends ControllerBase<T> {

    @PostMapping
    public T save(@RequestBody T entity) {
        return super.save(entity);
    }

    @Override
    @DeleteMapping("/{id}")
    public @ResponseBody T delete(@PathVariable Long id) {
        return super.delete(id);
    }

    @Override
    @GetMapping("/{id}")
    public @ResponseBody T get(@PathVariable Long id) {
        return super.get(id);
    }

    @Override
    @GetMapping
    public @ResponseBody List<T> getAll() {
        return super.getAll();
    }


}
