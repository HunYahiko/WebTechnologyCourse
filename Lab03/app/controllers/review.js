'use strict';

const Review = require('../models').Reviews;

module.exports = {
    create(req, res) {
        return Review
            .create({
                first_name: req.body.first_name,
                last_name: req.body.last_name,
                email: req.body.email,
                review_text: req.body.review_text
            })
            .then(review => res.status(201).send(review))
            .catch(error => res.status(400).send(error))
    },
    findByEmail(req, res) {
        return Review
            .findAll({ where: {email: req.params.email} })
            .then(review => res.status(200).send(review))
            .catch(error => res.status(400).send(error))
    },
    findAll(req, res) {
        return Review
            .findAll()
            .then(reviews => {res.status(200).render('./partials/read.ejs', {reviews: reviews} )})
            .catch(error => res.status(404).send(error))
    },
    update(req, res) {
        return Review
            .update(
                {
                    first_name: req.body.first_name,
                    last_name: req.body.last_name,
                    email: req.body.email,
                    review_text: req.body.review_text
                },
                {
                    where: {id: req.params.id}
                }
            )
            .then(updated => res.status(200).send(updated))
            .catch(error => res.status(400).send(error))
    },
    delete(req, res) {
        return Review
            .destroy(
            {
                where: {id: req.params.id}
            }
            )
            .then(deleted => res.status(204).send())
            .catch(error => res.status(400).send(error))
    }
};
