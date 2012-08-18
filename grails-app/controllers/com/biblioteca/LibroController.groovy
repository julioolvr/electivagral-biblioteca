package com.biblioteca

import org.springframework.dao.DataIntegrityViolationException

class LibroController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [libroInstanceList: Libro.list(params), libroInstanceTotal: Libro.count()]
    }

    def create() {
        [libroInstance: new Libro(params)]
    }

    def save() {
        def libroInstance = new Libro(params)
        if (!libroInstance.save(flush: true)) {
            render(view: "create", model: [libroInstance: libroInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'libro.label', default: 'Libro'), libroInstance.id])
        redirect(action: "show", id: libroInstance.id)
    }

    def show(Long id) {
        def libroInstance = Libro.get(id)
        if (!libroInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'libro.label', default: 'Libro'), id])
            redirect(action: "list")
            return
        }

        [libroInstance: libroInstance]
    }

    def edit(Long id) {
        def libroInstance = Libro.get(id)
        if (!libroInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'libro.label', default: 'Libro'), id])
            redirect(action: "list")
            return
        }

        [libroInstance: libroInstance]
    }

    def update(Long id, Long version) {
        def libroInstance = Libro.get(id)
        if (!libroInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'libro.label', default: 'Libro'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (libroInstance.version > version) {
                libroInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'libro.label', default: 'Libro')] as Object[],
                          "Another user has updated this Libro while you were editing")
                render(view: "edit", model: [libroInstance: libroInstance])
                return
            }
        }

        libroInstance.properties = params

        if (!libroInstance.save(flush: true)) {
            render(view: "edit", model: [libroInstance: libroInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'libro.label', default: 'Libro'), libroInstance.id])
        redirect(action: "show", id: libroInstance.id)
    }

    def delete(Long id) {
        def libroInstance = Libro.get(id)
        if (!libroInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'libro.label', default: 'Libro'), id])
            redirect(action: "list")
            return
        }

        try {
            libroInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'libro.label', default: 'Libro'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'libro.label', default: 'Libro'), id])
            redirect(action: "show", id: id)
        }
    }
}
